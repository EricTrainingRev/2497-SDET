/*
	SQL (Structured Query Language) is the syntax we use for interacting with relational
	databases. The reason they are "relational" is because we can create "relationships"
	between the records of our tables.
	
	Tables in relational databases are collections of columns and rows. The columns represent
	the discreet data stored in your records, and the rows represent individual records. In
	order to work with tables we need to use Data Definition Language (DDL), which is a 
	subset of SQL
*/

/*
 * 	create table teams tells the database we want to make a new table called "teams". Note that,
 *  at least in SQLITE, table names do not have their casing respected. It will all be lowercase
 */
CREATE TABLE teams(
	-- between the () we declare what columns we need in the table by assigning column names
	-- and types, along with potential constraints
	/*
	 * With the id column declared below we have three things happening. First is we gave the
	 * column the name of "id". Second we set the type of data stored in the column as the
	 * "integer" type. Finally, we declare this column to be the "primary key". This tells 
	 * us that the column acts as the unique identifier for all records added to this table. 
	 * Functionally, the "primary key" statement tells our database to add two constraints to
	 * the column: the "unique" and the "not null" constraints.
	 */
	id INTEGER PRIMARY KEY,
	name text,
	home_town text
);

create table players(
	id integer primary key,
	name text,
	home_town text,
	/*
	 * Here we are leveraging the relational power of relational databases. the team_id column
	 * below is set up as a foreign key that points to the primary key of the teams table. This
	 * means that each player record must have a valid team_id in order for it to be added to 
	 * the table. This allows us to always know what player is associated with what team.
	 * 
	 * One of the big things you want to avoid in relational databases is having "orphaned"
	 * records: this is a record with a foreign key that points to something that does not
	 * exist. To avoid this you can tell your database how you want to update records with
	 * foreign keys that are no longer valid. The example below tells the database to delete
	 * the record
	 */
	-- team_id is a foreign key: it points to the primary key of the teams table
	team_id integer references teams(id) on delete cascade
);


/*
	Once you have used DDL to set up your tables you are ready to start putting information 
	inside of them. Here we will start using Data Manipulation Language (DML), the second
	sub-language of SQL. This language controls creating records, updating records, and
	deleting records from our tables
 */

-- we will start with adding some teams first, since the players need teams to be assigned to
-- make sure to match the order of your values with the order of the columns you list
insert into teams (name, home_town) values ('Trail Blazers', 'Portland');

-- if you want to provide all the values you can just provide them in order they appear in
-- the table
insert into teams values (2, 'Lakers', 'Los Angeles');

-- you can insert multiple records at a time, just separate them via comma
insert into players (name, home_town, team_id) values
	('Damian Lillard', 'Oakland', 1),
	('Luka Doncic', 'Lubljanja?', 2);

insert into players values (3, 'Brandon Roy', 'Seattle', 1);
update players set id = 100 where name = 'Luka Doncic';

-- If you ever need to change a value in a record you can use the update command to change
-- one or more values in one or more records
update players set home_town = 'Ljubljana' where id = 2;

-- note how above we have a where statement that tells our database how to target one or more
-- specific records. If we don't have the where statement then ALL records in the table will
-- have the update applied to them
update players set name = 'Brandon Roy'; -- we are all now Brandon Roy

-- if you ever need to delete records you can do so with the delete command
delete from players where id = 1;

-- similar to the update command, if you leave off the where clause all records will
-- be deleted
delete from players;

-- the option above works for delting records, but there is actually a DDL operation called
-- truncate that should be preferred when you need to clear a table of its content
truncate table players;




/*
	Once you have your data in your database you need to be able to actually query the data.
	This is where Data Query Language (DQL) comes into play. DQL actions are all facilitated
	by the "select" key word
 */

-- the simplest DQL query is to select all records from a table
-- the star (*) indicates you want all columns
select * from players;

-- if you only want specific columns you specify them
select id, name from players;

-- add a where clause if you want to filter what records you get back
-- if no records match the result set returned will be empty (not an error)
select * from players where team_id = 3;

-- your where clause can have multiple filters. Here we filter by team_id and home_town
select name, home_town from players where team_id = 1 and home_town = 'Oakland';

-- if you ever want to filter by partial match you can use the % and _ to set that up.
-- % matches with 0 or more characters, _ matches a single character
select name, home_town from players where name like '%o%';
select * from players where name like '%cic';

-- we can limit the number of results in a result set
select * from players limit 3;

-- we can also order the results
select * from players order by home_town desc;

-- you can leverage limits and ordering to see subsets of data
select * from players order by home_town asc limit 3;

-- you can also offset your result sets, which tells the database to skip some records
-- when returning your result set
select * from players order by home_town asc limit -1 offset 2;

/*
	When you query with data using DQL often you will need to transform that data in some
	way. This can be done in your main application, but SQL does offer quite a few helper
	functions to perform common data transformation and other types of operations that
	can be done in the database for you
 */

-- scalar functions are functions that are applied to each individual record's column
select upper(name) from players;

-- aggregate functions are functions that take all provided values and combine them into a
-- single result
select count(*) from players;

-- when using aggregate function it is worth considering setting an alias for the results of the
-- operation. This sets the name of the column for the result set where the data is stored
select sum(id) as id_total from players;

-- aliases can be applied to any column: this changes the column name in the result set
select name as player_name from players;

-- multiple aliases can be set
select name as player_name, home_town as city, team_id as employer from players;













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


-- If you ever need to change a value in a record you can use the update command to change
-- one or more values in one or more records
update players set home_town = 'Ljubljana' where id = 2;

-- note how above we have a where statement that tells our database how to target one or more
-- specific records. If we don't have the where statement then ALL records in the table will
-- have the update applied to them
update players set name = 'Brandon Roy'; -- we are all now Brandon Roy










# SQL Review Assignment: Bank Database

This assignment reviews the SQL you'll need day to day. A provided script builds a small bank database, loads it with data, makes a few changes, and runs some sample queries. You finish it with seven tasks: four **queries** (filtering, joining through a junction table, aggregating, removing duplicates) and three **data changes** (an update across a join, a two-step transfer, and a rename).

---

## Pick Your Script

All three scripts build the same tables and data. Only the syntax differs, so use the one that matches the database you have installed.

| Database | Script |
|---|---|
| MySQL | `sql-assignment-mysql.sql` |
| PostgreSQL | `sql-assignment-postgres.sql` |
| SQLite | `sql-assignment-sqlite.sql` |

## Running the Script

The script rebuilds the database from scratch every time it runs. Write an answer, run the **whole** script, and check your results. Because tasks 5–7 change data, re-running is also how you get back to the starting point.

**MySQL** — replace each `<YOUR_DB_NAME>` at the top of the script with a name such as `bank`. Then run the whole script in MySQL Workbench, or from the `mysql` client:

```console
SOURCE sql-assignment-mysql.sql;
```

**PostgreSQL** — create the database once and connect to it (the comment at the top of the script shows how). Then run the whole script in pgAdmin or DBeaver, or from `psql`:

```console
\i sql-assignment-postgres.sql
```

**SQLite** — the database is a single file. Open (or create) it with `sqlite3 bank.db`, then:

```console
.read sql-assignment-sqlite.sql
```

---

## The Database

| Table | Holds |
|---|---|
| `address` | Street, city, state, and zip |
| `customers` | Each customer's name (first and last together, in one column) and their address |
| `accounts` | Each account's balance |
| `accounts_customers` | Which customer owns which account |

Customers and accounts aren't linked directly. `accounts_customers` is a **junction table** between them, so a customer can own several accounts. Any question about a customer's money has to join through it.

The script's **MAKE SOME CHANGES** section runs before your tasks. By the time you start, every balance has grown 5%, John Cross's account is 25,000 lower, and Amanda Smith's address has been changed to match Jason A. Lastname's. Your results should reflect those changes.

---

## Tasks

Write each answer below its `TODO` comment in the **TEST YOUR SKILLS** section, and work in order. The checks assume the earlier tasks have already run.

### Task 1: Customers named Smith

List every customer whose last name is Smith. First and last names share one column, so match on how the name ends, not on "Smith" appearing anywhere in it.

**Check:** 2 rows: Jason Smith and Amanda Smith.

### Task 2: Total balance held by the Smiths

Add up the balances of every account owned by a Smith. This needs the junction table to get from customers to their accounts.

**Check:** a single value: 4666.29.

### Task 3: Customers with less than $50 in an account

Show the name and address of every customer who has at least one account under $50. A customer with two qualifying accounts would appear twice, so remove duplicates.

**Check:** 1 row: Amanda Smith, 74 Daytona Ave., Albany, NY.

### Task 4: Customers in Texas

List every customer whose address is in Texas.

**Check:** 2 rows: Jason Smith and Marty Gras.

### Task 5: A $100 gift for New York customers

Add $100 to every account owned by a customer in New York, using a single `UPDATE`. Caveat: the syntax for joining inside an `UPDATE` differs between databases, but a subquery in the `WHERE` clause that finds the right account IDs works in all three.

**Check:** 3 accounts change: 900003 to 257.50, 900004 to 114.00, and 900007 to 1512.95. Total deposits go up by exactly 300.

### Task 6: Transfer $199.99

Move $199.99 from Jason Smith to Amanda Smith with two statements: one takes it out, one puts it in. Jason and Amanda each own two accounts, so pick one of each and note which ones in a comment. Money moves; it isn't created or destroyed.

In a real system, these two statements would be wrapped in a **transaction** so they succeed or fail together. A transfer that only half-runs either loses money or creates it.

**Check:** Jason's chosen account is 199.99 lower, Amanda's is 199.99 higher, and total deposits are unchanged from after Task 5 (99342.20).

### Task 7: Rename Amanda

Change Amanda Smith's last name to "Lastname". The name is stored as one value, so update the whole name.

**Check:** customer 2 is now "Amanda Lastname". A Smith query run after this point returns only Jason Smith.

---

## Done

You're finished when all seven `TODO`s have answers, the whole script runs top to bottom without errors, and each result matches its check.

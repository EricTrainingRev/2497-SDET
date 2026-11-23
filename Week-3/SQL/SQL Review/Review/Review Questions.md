# SQL Review — Review Questions

1. The bank assignment keeps customers, addresses, and accounts in separate tables instead of one wide table. What does splitting related data into separate tables gain us?

2. MySQL, PostgreSQL, Oracle, SQL Server, and SQLite all implement the SQL standard with their own additions. What carries over unchanged between them, and what kinds of things typically have to change when moving a script from one to another?

3. The assignment stores `balance` as `DECIMAL(10, 2)` rather than `FLOAT`. What do the two numbers mean, and why is a floating-point type a poor fit for money?

4. A primary key is made of two other constraints. Which two, and why does every table need a column (or set of columns) that satisfies both?

5. In the assignment, `accounts_customers` has foreign keys to `accounts` and `customers`. What does a foreign key prevent, and why does it force the script to create, insert into, and drop tables in a particular order?

6. One customer can own many accounts, and an account could be owned by more than one customer. Why can't that relationship be modeled with a foreign key column on either `customers` or `accounts`?

7. `DELETE FROM accounts` and `DROP TABLE accounts` both make the data disappear. What's left afterward in each case, and which sub-language does each belong to?

8. The assignment's first `UPDATE` (the 5% interest) has no `WHERE` clause. Which rows does it change, and why is it worth checking every `UPDATE` and `DELETE` for a `WHERE` clause before running it?

9. In a `LIKE` pattern, what does `%` match? Why does `'% Smith'` find customers with the last name Smith more reliably than `'%Smith%'`?

10. The "State Balance" query uses `GROUP BY ad.state` with `SUM(a.balance)`. What does `GROUP BY` do to the rows, and why can't that same query also select a customer's name?

11. Task 3 asks for customers with less than $50 in an account, with no duplicates. Why can joining customers to their accounts return the same customer more than once?

12. Suppose a customer has no accounts yet. Which join between `customers` and `accounts` still includes that customer, and what appears in the account columns for them?

13. Any `RIGHT JOIN` can be rewritten as a `LEFT JOIN`. How, and why do most teams write `LEFT JOIN` consistently?

14. What kind of data calls for joining a table to itself? Why does a self-join require table aliases?

15. A cross join between `address` (5 rows) and `accounts` (7 rows) returns 35 rows. Why, and when is that kind of result actually useful?

16. What's the difference between an equi join and a theta join?

17. A join combines tables side by side; `UNION` stacks the results of two queries. What must two queries have in common before `UNION` can combine them?

18. Why is `UNION ALL` usually faster than `UNION`, and when do we need `UNION` anyway?

19. Constraints already stop bad data from getting in. What problem does DCL (`GRANT` / `REVOKE`) solve that constraints don't?

20. Task 6 moves $199.99 between two accounts using two `UPDATE` statements. What can go wrong if those statements run outside a transaction, and which ACID property prevents it?

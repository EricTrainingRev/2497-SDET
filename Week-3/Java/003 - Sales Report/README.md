# Mini-Project: Sales Report

This project reviews foundational Java through a partially built program that reads a file of sales data, parses each line into a `Sale` object, filters and sorts the results, and prints them. You'll finish the missing pieces: **overloaded constructors**, **overriding `equals`, `hashCode`, and `toString`**, and **parsing with exception handling and custom exceptions**. Then you'll write **JUnit tests** for provided code you didn't write.

You'll work almost entirely through the test suite. A `main` method exists to run the program end to end, but each task is checked by running the tests, not the program.

---

## Prerequisites

| Software | Required Version |
|---|---|
| JDK (Temurin or any OpenJDK build) | 21 (LTS) |
| Apache Maven | 3.9.x |
| JUnit (via `pom.xml`, no install needed) | 5.11.x |

Check the first two with `java -version` and `mvn -version`. Then, from this project's folder, run the test suite:

```console
mvn test
```

At the start, **every test fails**. That's expected: each failure is a task waiting to be done. You can run one test class at a time while you work on its task:

```console
mvn test -Dtest=SaleTest
```

Once tasks 1–3 are done, you can run the whole program:

```console
mvn -q compile exec:java
```

---

## The Program

### The data

`src/test/resources/sales.csv` holds one sale per line:

```
saleId,product,quantity,unitPrice[,discountPercent]
1001,Widget,5,19.99
1002,Gadget,2,49.50,10
```

| Field | Type | Rule |
|---|---|---|
| `saleId` | `String` | — |
| `product` | `String` | — |
| `quantity` | `int` | Greater than 0 |
| `unitPrice` | `double` | Not negative |
| `discountPercent` | `int` | Optional; 0–100; defaults to 0 when missing |

The file deliberately contains bad lines. Each kind of problem has its own custom exception:

| Problem | Exception |
|---|---|
| Wrong number of fields | `MalformedRecordException` |
| A number field that isn't a number | `InvalidNumberException` |
| A number outside its allowed range | `InvalidValueException` |

The file also has a header row, a blank line, and a line with extra spaces around its values. The header and blank line are skipped. The line with extra spaces is valid.

### The files

All source is in `src/main/java/com/curriculum/labs/`; tests are in `src/test/java/com/curriculum/labs/`.

| File | Who writes it |
|---|---|
| `Sale.java` | **You:** constructors and `Object` overrides. Fields, getters, and `getTotal()` are provided |
| `SaleParser.java` | **You:** `parseLine` |
| `MalformedRecordException.java`, `InvalidNumberException.java`, `InvalidValueException.java` | Provided |
| `SalesFileReader.java` | Provided: reads the file and calls your `parseLine` for each line |
| `SalesReport.java` | Provided: filters and sorts sales by total |
| `Main.java` | Provided: runs the program and prints the results |
| `SaleTest.java`, `SaleParserTest.java` | Provided: these check your code |
| `SalesFileReaderTest.java`, `SalesReportTest.java` | **You:** these check the provided code |

Every place you write code is marked with a `TODO:` comment naming its task. Stubbed methods throw `UnsupportedOperationException`, and stubbed tests call `fail`, so nothing passes until you fill it in.

---

## Tasks

Work in order. Each task depends only on the ones before it, so a failing test always points at the task you're on.

### Task 1: Overloaded constructors (`Sale.java`)

Fill in two constructors: one that takes every field, and a shorter one for records with no discount. Real data doesn't always include every field, and overloading lets callers build a valid sale either way. The shorter constructor should call the full one with a discount of 0 rather than repeating the field assignments.

**Check:** the constructor tests in `SaleTest` pass.

### Task 2: `equals`, `hashCode`, and `toString` (`Sale.java`)

Override the three methods every class inherits from `Object`. `equals` lets two sales with the same data count as the same sale; later tests compare whole lists and depend on it. `toString` makes printed output and failing test messages readable.

Caveats: `equals` and `hashCode` must use the same fields. `toString` can use any readable format, including one your IDE generates, as long as every field's value appears in it.

**Check:** all of `SaleTest` passes.

### Task 3: `parseLine` (`SaleParser.java`)

Turn one line of the file into a sale object. Keeping this separate from file reading means it can be tested with plain strings, no file needed. Split the line, trim each field, and check it against the rules in the method's comment, throwing the matching custom exception for each problem.

Caveats: check the field count before reading any fields. When a number fails to convert, catch that failure and rethrow it as `InvalidNumberException` with the original as the cause. Lines with extra spaces are valid and should parse.

**Check:** all of `SaleParserTest` passes.

### Task 4: Tests for the file-reading loop (`SalesFileReaderTest.java`)

Write tests for provided code you didn't write, working from its described behavior (the comment on `SalesFileReader.readSales`) rather than its implementation. Cover the number of valid sales read from the sample file, bad lines being skipped, and a missing file throwing an exception.

Caveats: the loop calls your `parseLine`, so task 3 must pass first. Count the valid lines in the sample file by hand to know what to expect.

**Check:** your tests in `SalesFileReaderTest` pass.

### Task 5: Tests for the filter and sort methods (`SalesReportTest.java`)

Build your own sale objects and pass them to the provided methods in `SalesReport`. For the filter, cover matching sales being kept, a sale exactly at the minimum, no matches, and an empty list. For the sort, cover descending order by total, a discount changing the order, an empty or single-sale list, and the original list being left unchanged.

Caveats: pick values whose totals are easy to work out by hand. Comparing lists relies on the `equals` you wrote in task 2.

**Check:** your tests in `SalesReportTest` pass.

---

## Done

You're finished when `mvn test` reports no failures and no errors, and `mvn -q compile exec:java` prints the sales with a total of at least 50, largest first.

# Test Case Design

## Test Case Anatomy
- preconditions
    - setup methods handle this
- inputs
    - test data
- actions
    - typically the method being tested or workflow being conducted (think user story)
- expected results
    - what should have happened
        - if what should have happened does indeed happen your test "passes"
        - if what should have happened does not happen your test "fails"
            - always remember: a failing test due to an assertion that is not met means you have actually done your job as a tester: you have created a test that discovered a defect. Test fails are, in a strange way, a good thing

arrange, act, assert

## Testing Principles to Internalize
1. Testing reveals defects, not their absence
2. Exhaustive testing is impossible 
3. Test early
4. Defects cluster
5. Tests wear out
    - pesticide paradox
6. Testing is contextual
7. Absence of error fallacy

## Happy Path & Sad Path Testing
Happy path (positive) testing is testing done with valid inputs (test data and actions performed)
- valid =  conforms to any/all requirements

Sad path (negative) testing is testing done with invalid inputs (test data and actions performed)
- invalid = does not conform to one or more requirements

## Black Box Techniques
Black Box Techniques do not require or expect the tester to have access to the underlying systems being tested. This would be the source code of the application: the code is not considered during test creation. This makes these techniques particularly useful for System and Acceptance level tests, but they can still be used if you take the underlying system into consideration. Tests and their data are planned through analysis of documentation, requirements, and stakeholder expectations

### Equivalence Partitioning
Consider we have a registration feature and one of the requirements for new accounts is they must have a username, and that username must
have lowercase, uppercase, and numeric characters (at least one of each). At a minimum, we need at least two usernames for our test data: one representing a "valid" username, and one representing an "invalid" username
- valid username = "Use3r"
- invalid username = "My_username"

We can use the two usernames above to each represent their entire "class" of data. "Use3r" can be our representative of all valid username inputs, and "My_username" will be the representative of all invalid usernames. If our positive test passes with our valid username we assume it will still pass if we provide any other value that would be considered valid by the requirement. Likewise, if our test with the invalid data passes we assume that any invalid test data we provide that fits in the category would similarly still pass

### Boundary Value Analysis
Equivalence Partitioning is a good choice when your requirements do not have hard boundaries. When a requirement does have a "hard" boundary, think usernames must be 5-15 characters, Boundary Value Analysis becomes a good choice for organizing your test data. Anytime you have these types of boundaries your defects will typically be on the "edges" of those boundaries. Boundary Value Analysis is organizing your test data so that your tests ensure your requirements are enforced at the boundary. If the boundaries have the business rules enforced, you can safely assume any values within the boundary are also enforced
- just outside the lower boundary = "Use3"
- just inside the lower boundary = "Use33"
- just inside the upper boundary = "UserNameGood123"
- just outside the upper boundary = "UsernameBad12345"

This is a few more test inputs than when we just did Equivalence Partitioning, but each test provides us with meaningful, non-redundant information. This is the benefit of Equivalence Partitioning and Boundary Value Analysis: by allowing single values to represent all possible values within their class we strike a good balance between test coverage while minimizing the number of tests we actually have to build/run

### Decision Table
Once you have your test data that data must be organized. A simple way to organize your data and make sure that you have sufficient coverage for your requirements is to organize your data in a decision table.
|username|password| expected outcome|
|-------|-------|-----------------|
|valid  | valid | user is registered|
| invalid| valid | user is not registered|

| username| password| expected outcome|
|---------|---------|-----------------|
|Use3     |valid    | user not registered|
|Use3     |invalid  | user not registered|
|Use33    |valid    | user is registered|
|etc      | etc     | etc|

The benefit of organizing your test data into one or more decision tables is it provides a quick snapshot of how many tests you are going to need to build, and a quick view of what the results of those tests should be. All rows with only positive data are going to be your happy path tests. Any row that has one more more invalid pieces of test data are going to be your sad path tests
# Test Mentality Review — Review Questions

1. A test suite runs with every test passing. Why doesn't that prove the software is free of defects, and what does a passing suite actually tell us?

2. Quality assurance is described as preventive and quality control as corrective. Using a required code review and a failing regression test as examples, what makes one preventive and the other corrective?

3. A test enters an invalid password, and the application correctly shows an error message. Is that a positive or a negative test, and did it pass? Why do people often mix these two ideas up?

4. One requirement says "a user can log in with valid credentials"; another says "login responds within two seconds." Why does each kind of requirement lead to a different kind of test?

5. Why does a defect found while reviewing requirements cost far less to fix than the same defect found in production?

6. Which kinds of testing are best automated, and which still need a person? Why?

7. The Software Testing Lifecycle begins with requirement analysis, before any test cases are written. Why does it start there?

8. What question does a Requirements Traceability Matrix answer that a list of test cases alone can't?

9. A developer fixes a defect. Why does it go back to a tester for verification instead of being closed by the developer?

10. Why are a defect's severity and priority tracked as two separate fields? Describe a defect where they disagree.

11. After a defect is fixed, why do we run regression tests rather than only re-running the test that originally failed?

12. What makes a defect report something a developer can act on right away?

13. Why should test data include invalid and edge-case values, and why does it matter that the data is reset between test runs?

14. The testing pyramid calls for many unit tests and few end-to-end tests. Why that shape instead of the reverse?

15. What can a white-box tester do that a black-box tester can't? Why is black-box testing still the norm at the system and acceptance levels?

16. A test case reads "Check that login works." What's missing that makes it unusable, and why does each missing piece matter?

17. A field accepts between 1 and 100 items. Which values would boundary value analysis test, and why are boundaries such a common place for defects?

18. Equivalence partitioning tests one value from each partition. Why can one value stand in for the rest, and what risk are we accepting by doing that?

19. When a feature's outcome depends on several conditions at once, how does a decision table help?

20. Exploratory testing has no predefined test cases. When is it more effective than scripted testing, and what separates it from random clicking?

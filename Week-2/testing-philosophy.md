# Testing Philosophy: Why Test?
Testing Philosophy is simply the underlying beliefs, goals, and vocab that controls how we go about testing software.

## Core Concepts

### Quality Assurance & Quality Control
Two terms that represent different approaches for maintaining a high level of "quality" in a product or service. What do we mean by quality?
- quality is a catch-all term used to represent the features, components, and non-tangibles of a service/product that all contribute to the satisfaction of the user

QA & QC are two approaches to maintaining a high level of product quality

**Quality Assurance**
- process oriented approach
    - asks the question "do the processes we go through help or hurt the quality of our product?"
- "ensuring good process leads to go product"

**Quality Control**
- product oriented approach
    - this is about identifying and fixing defects in the product
- "ensure the product meets quality standards"


### Verification & Validation
Verification and Validation are ways of classifying the type of testing we are doing

**Verification**
- "Are we building the product correctly?"
    - test cases passing indicate the product is being built correctly
    - test cases failing indicate the product is not being built correctly
- often done at the unit/integration level
    - think tests done on the source code itself in small units

**Validation**
- "Are we building the right product?"
    - test "cases" passing would involve things like stakeholders giving their approval for the product you are building, users reporting satisfaction with the application, any sort of non-functional positive feedback
    - test "cases" failing would involve things like stakeholders giving critical feedback on the product, users reporting unhappiness with the application, this kind of non-functional negative feedback
- often done at the system/integration level
    - think tests done on the system as a whole

to put it succinctly:
- verification answers the question "does the product match the specs?"
- validation answers the question "does the user find this useful?"

### Error & Defect & Failure
- *Error* = a mistake made by a person
    - this can be any mistake by the developer: think referencing the wrong variable, forgetting to close a resource, setting up multithreading incorrectly so a live-lock is created, etc.
- *Defect* = incorrect behavior or failed requirement present in software
    - an error (see above) in your software leads to the actual problem, the defect, being present in your code. This means "error" represents the human mistake, "defect" represents the mistake itself within the code
- *Failure* = this happens when a defect is executed
    - anytime your code does something unexpected because of a "defect" in the system you get a "failure": this can be anything from the wrong value being returned, your code crashing, a process taking too long, any witness/live deviation from the expected in your running code is a "failure"

error (human mistake) -> defect (mistake/deviation in the code) -> failure (observed deviation in running code)

### Requirements
Requirements specify what should & should not be part of a product
- technical requirements
- business requirements
- regulatory requirements
- accessibility requirements
- deployment requirements

fundamentally, ANYTHING that should be considered when building/testing/maintaining a product is a type of requirement. It is the collection of requirements that inform us on what the product actually is, and how we should go about building/testing/maintaining that product.

requirements can be functional and non-functional
- functional requirements refer to the actions/capabilities of the product
    - login
    - registration
    - withdraw money
    - order a coffee
    - any feature or capability of the application
- non-functional requirements refer to the auxiliary concerns of the product
    - response time of requests
    - availability of the product
    - Transactions per second the product can handle
    - the regulatory compliance of the application
    - any need that is not specifically concerned with the features of the application

## Tester Mindset
Testers need to approach software with a different but complimentary mindset to developers

developers:
- goal oriented
- "how do I make this work?"
- solution focused
- risk is technical/performance focused
- build the application

testers:
- problem oriented
- "how do I break this?"
    - testers want to find *defects* created by developer *errors* in testing before those *failures* are discovered in production
- user perspective focused
    - rather specific user perspective: the problematic user
- risk is failure focused: we want to catch defects in testing so that they never reach production
- find the weaknesses and vulnerabilities of the application

Together, developers and testers taking these different approaches to the application can lead to a much higher quality product than if one or the other was left off
- no developers means no product
- no testers means you effectively are testing in production: it is never a good idea to have your end users be your testers

Always remember developers and testers are on the same team: they should fill complimentary roles, not adversarial roles. It is always best to cultivate a positive relationship between the dev team and the test team when they are separate

## Static & Dynamic Testing
Testing can be done whether or not you have running software. The difference in categorization is simply whether or not the software is running. If it is running you are doing "dynamic" testing, otherwise you are doing "static" testing

Dynamic Testing
- requires software to be running
- checks actual code execution: inputs, outputs

Static Testing
- does not require running software
- checks documentation, involves code reviews, static code analysis, linting, etc.

## Automated & Manual Testing
Automated testing is oftentimes used with dynamic testing and involves letting software facilitated the execution and reporting of test results. Manual testing involves a person looking over your resources and reporting on the results instead of handing off those responsibilities to code

automated testing
- easy to repeat tests
    - particularly useful for complex, tedious, or repetitive tests
- setting up automated tests is time consuming, and it requires a level of technical expertise 
- tend to run much quicker than manual tests

manual testing
- useful for one-off types of tests
    - not a great choice if the test is complex, tedious, or repetitive, which should be automated if possible
- unlike automated testing which requires technical expertise, manual testing has a much lower barrier of entry: give someone instructions, they follow those instructions, and if they note any failures they report them
- these tests take typically much longer to complete than automated tests

## Testing Pyramid
All testing fits in one of four levels: these levels are known as the Testing Pyramid
- Acceptance Testing
    - testing done on the finished product from the user perspective
        - acceptability (does the user actually like the product)
        - regulatory compliance (does the product meet law requirements)
        - any subjective test fits at this level
- System Testing
    - testing done on the product that incorporates all related systems and components
        - End to End testing (can a user register a new account through the web portal)
        - performance testing (do HTTP requests get handled within an acceptable time range)
- Integration Testing
    - Testing done on related components of your software
        - JUnit tests on your business layer which itself utilizes the Repository layer to facilitate database interactions
        - API testing your application controllers
        - Testing your UI loads the correct the resources with a mocked backend
- Unit Testing
    - Testing done to individual components of your application in isolation
        - JUnit tests on individual methods
        - API tests to validate the schema, status codes, etc. of your controllers in isolation
        - individually testing components of your web app

## Testing Components
All of your tests are going to have (or should have) a large collection of data and work behind them. This means your tests should not exist in a vacuum: you should never say a test exists because "i think it is a good idea". The following test components should help you to determine your backing data for every test you create
- **Test Basis**
    - This is what we call the complete collection requirements and documentation you have access to that inform you on the product being built/needing to be tested
    - in other words, Test Basis is the stuff that tells you what you need to test
    - all tests should have some "basis", some root cause, a document, requirement, something that gives reason for the test to exist. If you can not point out a discreet resource that gives legitimacy to your test, it means your test has no "basis", and therefore is not needed
    - test basis provides the reasons for your tests
- **Test Analysis**
    - this is the process of studying your **test basis** to determine what actually needs to be tested
    - this process helps us to determine the **test conditions** we are working with
- **Test Conditions**
    - these are the aspects of the software that actually need to be tested. These are going to be things like your functional requirements, your performance needs, your accessibility targets, anything that can be measured/verified/confirmed is a test condition
    - after we have determined our **test conditions** we are finally able to pin down what our actual **test objectives** are.
- **Test Objective**
    - these are the actual reasons we test. Objectives can be things like validating functional requirements, checking performance meets our standards, etc.
    - **Test Objectives** will have one or more **test objects** associated with them
- **Test Object**
    - these are the resources that testing is actually done on
        - if you have a registration method, the **test object** is the method itself
        - if you have a user story for users logging in, the user story can be a test object
    - your **test objects** are the focus of any **test cases** you build
- **Test Case**
    - these are formal detailed sets of the following
        - preconditions
        - inputs
        - actions
        - expected results
    - **Test Cases** require **Test Data**, and tend to be organized in **Test Suites**
- **Test Data**
    - these are the values used as inputs, and possibly expected outputs, for your test cases
- **Test Suites**
    - these are collections of related **Test Cases**
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
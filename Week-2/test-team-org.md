# Test Team Organization

## Test Team Roles
Whatever the organization/structure of your testing team, there are at least 4 roles that must be filled. These roles are:
- Test Manager
    - essentially a project manager, this role handles the cross-team communication, helps manage workloads in the team, and handles communication with stakeholders
- Testers
    - these are the people who do the actual testing. They participate in the whole testing lifecycle and report their work to the test manager
- Business Analysts
    - these people act as a sort of "translator" for the testing team and stakeholders. They are technical individuals so they understand the verbiage, needs, and concerns that testers convey, but they also have business knowledge. This allows them to better understand stakeholder concerns and priorities. Being able to "speak" both technical and business language allows for BAs to be a go-between and help
    both sides better understand what the other is saying
- Stakeholders
    - these are the people you are building the application for; these are your employers, contractors, etc. They are the people "in charge".

## Software Testing Life Cycle
When you are part of a testing process there are 6 standard phases of work you will need to accomplish. The order you do the work may change, the name of the phases may vary, but the work itself should be completed all the same.
1. Requirement Analysis
    - during this phase the team reviews documentation, expectations from stakeholders, and gather any other resources needed in order to actually determine what needs to be done
        - this is where your Test Basis is determined 
2. Test Planning
    - having figured out your basis, it's time to determine what your Test Objectives are, which will help to determine your actual Test Objects
    - this is also the phase where you put together your test data: depending on the type of testing you are doing there will be different techniques you can do to optimize the amount of test data you need 
3. Test Case Design*
    - this is where we actually make our test cases
        - determine test preconditions
        - determine test inputs
        - determine expected test outputs
    - for automated testing this is the phase where the code is written for the tests
4. Test Environment Setup*
    - this is where the data and environment necessary for the tests to run are set up
        - setting up your test database
        - spinning up the web server
        - requisitioning cloud resources
        - scheduling manual testers
5. Test Execution
    - this is where the official test results are generated
    - the results of this final test flow should be saved and archived
    - it is common to generate multiple forms of test results
        - human readable form
        - CI/CD friendly form
        - you will typically want to save archived versions of your test reports
6. Test Closure
    - this is where you report on the results of your tests to the stakeholders
    - you generate defect reports and prepare to fix the defects discovered, or at least report those defects to the development team to fix
    - this is the time to have a team retrospective
        - discuss what went well
        - discuss what needs to be improved
        - call out any work that was not completed in the cycle of work that needs to be done next test cycle

## Defect Life Cycle
The defect life cycle is a way of organizing your approach to fixing defects discoverd by your tests. 
1. Defect Identification
    - defects are discovered during testing, which means the defect lifecycle itself actually starts as a sub-workflow of the testing lifecycle
    - all defects discoverd should ideally have a defect report generated
2. Categorization & Prioritization
    - All defects should have at least two attributes
        - **severity score**
        - **priority score**
    - defects with high priority scores should be handled before defects with low priority scores
    - severity scores should be used to help the fixer for the defect understand the scope of the defect
3. Assignment
    - someone has to be told to fix the defect
    - typically this is handled by a project manager, on a smaller team it may be volunteer based
4. Analysis & Planning
    - once the defect is assigned the assignee needs to go in and figure out what is causing the defect
        - the assignee may be unable to reproduce the defect, and therefore the defect is "rejected"
        - the assignee may learn the defect is being fixed as part of a wider update, and so the defect can be "rejected"
        - it may be determined the defect is actually something desirable by the stakeholders, so the defect is "rejected"
            - it's not a bug, it's a feature
5. Fix
    - the assignee goes in and actually fixes the error in the code that lead to the defect
6. Verification
    - rerun your test to make sure the failure is no longer present
        - if the failure no longer exists you can close the defect
        - if it still exists you go back to analysis and planning
7. Closure
    - close the defect, create a report on the work done
    - periodically aggregate your defect reports and inform stakeholders of the work that has been done

## Testing Documentation
There are some common documents used by testing teams to help facilitate, order, and keep track of work
- Test Plan
    - a strategic document for the whole testing lifecycle, it includes multiple important details for your testing work
        - test objectives
        - schedule
        - estimates
        - deliverables
        - reference to other documents
- Test Schedule
    - timeline for your testing activities
        - this can be a fine-grain schedule with individual test timelines
        - high level overview of the testing timeline, more focused on sprint details than individual test details
- Requirements Traceability Matrix
    - This is a bidirectional map of requirements
        - user stories/features should be mapped to requirements
        - requirements should be mapped to test data
        - test data should be mapped to test cases
        - test cases should be mapped to defects
    - RTMs are meant to be "living documents"
        - as test basis/conditions change, your RTM should be updated to accommodate those changes
            - this could mean adding on new requirements, test data, etc.
            - this could mean removing old requirements, test data, etc.
- Software Requirements Specification
    - SRSs are detailed descriptions of the software being tested/built
        - this is where the requirements for the application exist
        - this is an invaluable tool for getting started with setting up a RTM: the user stories/feature and the requirements for those features can usually be mapped from this document
- Test Progress Report
    - a test progress report is any test report generated before the end of the test cycle
        - reports on tests run
            - \# passing tests
            - \# failing tests
            - \# skipped tests
- Test Summary Report
    - THE test report generated at the end of the test cycle
    - this is the final report presented to stakeholders and archived for future reference
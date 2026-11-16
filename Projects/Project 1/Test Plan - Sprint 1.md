# Planetarium Test Plan
This document outlines the Test Objectives, User Stories, and the Testing and Reporting requirements for the Planetarium application in this first Sprint

## Test Objectives
- Validate the Planetarium application allows the fulfillment of all User Stories
- Validate the Planetarium enforces all Security Requirements
- Validate the Planetarium enforces all Software Requirements
- Assess the Planetarium application user acceptability via User Acceptance Testing

## User Stories
- As a new user I want to open an account with the Planetarium so I can save my celestial findings	
- As a user I want to securely access my account so I can interact with the Planetarium in a secure environment
- As a user I want to see my planets and moons added to the Planetarium so I can track my findings	
- As a user I want to add new planets and moons to the Planetarium so I can update my findings	
- As a user I want to remove planets and moons from the Planetarium so I can correct my findings

## Testing Requirements

### System Testing Requirements
- All User Stories require happy path testing to validate the User Story can be achieved
- All User Stories with security and/or business requirements require sad path testing to validate requirements are implemented

### System Testing Reporting
- All System Test results should be saved in the following formats:
    - HTML for human readability
    - XML for integrating the test results with future results
- All discovered defects should have an associated defect report created
    - similar/related defects may share a single defect report

### Acceptance Testing Requirements
User Acceptance Testing for the user experience should answer the following questions in detail for each User Story:
- Is the intended use of the service intuitive?
- Is the service easy to use?
- Does the service inspire confidence?
- Is the service pleasing to look at?

### Acceptance Testing Reporting
UAT reporting should include the following features:
- a grade to provide a quick indicator of how well/poor a User Story was scored
    - 1 = bad
    - 2 = ok
    - 3 = good
    - 4 = exceptional
- a paragraph description describing the reasons for the score 
- the report should be saved in some form of text document
- every User Story is scored and justified in a paragraph (no numeric-only rows)
- a score of 2 or higher requires the User Story to be complete on its happy path — a story with a happy-path defect cannot be scored "exceptional" or "good"

### Security Testing Requirements
Security Testing should be performed to validate sensitive information is obfuscated and/or inaccessible to end users through the use of Error Guess testing. Any defects discovered should have an associated defect report. Note this may require Manual Testing in some cases

**Security Testing Success Criteria:**
- Test scope covers the three security requirements: passwords never visible in plain text, users interact only with resources they added, and only logged-in users access the home page
- A probe counts as a defect only when a requirement is actually violated: a plaintext password appears in any response or DOM, a user can access/fetch/delete another user's resource (verified at the API level by resource ID, not just by the absence of a UI link), or a protected page loads without authentication

### Security Testing Reporting
Security Testing reporting should include at minimum a paragraph write-up including the following information within the defect report:
- what feature was tested
- what action was taken to test the feature
- what was the result
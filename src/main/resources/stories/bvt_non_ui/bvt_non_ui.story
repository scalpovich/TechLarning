Narrative:
In order to verify the build
As an issuer
I want to run few tests

Meta:
@StoryName debit_emv_retailBVT
@NonUIBVTest

Scenario: Set up prepaid emv retail travel card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
Then user sign out from customer portal

Scenario: prepaid emv retail travel card device production
Meta:
@TestId TC408068
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status

Scenario:2 Non-UI Verification - emv debit card manual authorization
Meta:
@TestId TC408283
Given user is logged in institution
Given a new device was created
Given user raises an authorization request
Then status of request is "approved"


Scenario: Non-UI Verification - Event Trigger Validation
Meta:
@TestId TC398136
Given user is logged in institution
When user is at the home tab
And user searches for alert on ui
Then EventAlertHistory page of card management tab is rendered correctly
Then verify that alert was successfully triggered
And user signs out from customer portal

Scenario:3 Non-UI Verification - Report Generation
Meta:
@TestId TC398141
Given user is logged in institution
When user is at the home tab
Then verify report for Auth is downloaded

Scenario: Non-UI Verification - Statement Generation
Meta:
@TestId TC398138
Given user is logged in institution
When "Statement" download batch is executed for prepaid 
Then Statement download batch is available on Batch Job History Page
Narrative:
In order to verify the build
As an issuer
I want to run few tests

Meta:
@StoryName debit_emv_retailBVT
@NonUIBVTest

Scenario: Set up emv corporate gift prepaid card
Meta:
@TestId TC407061
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: emv prepaid corporate gift card device production
Meta:
@TestId TC408234
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk

Scenario: emv corporate gift prepaid card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
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
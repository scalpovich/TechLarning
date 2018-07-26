Narrative:
In order to verify the build
As an issuer
I want to run few tests

Meta:
@StoryName debit_emv_retailBVT
@NonUIBVTest

Scenario:1 Non-UI Verification - Set up emv debit card and device production
Meta:
@TestId TC398108
Given user is logged in institution
When User fills Dedupe Plan
When User fills MCC Rules for prepaid product
When User fills Transaction Plan for prepaid product
When User fills Transaction Limit Plan for prepaid product
When User fills Document Checklist Screen for prepaid product
When User fills Device Joining and Membership Fee Plan for prepaid product
When User fills Device Event Based Fee Plan for prepaid product
When User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
When User fills Wallet Plan for prepaid product
When User fills Program section for prepaid product
When User fills Device Range section for prepaid product
When user assigns service code to program
When user creates new device of prepaid type for new client
Then device has "normal" status
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
!-- And processes pin generation batch for debit
!-- When user has wallet number information for debit device
!-- When user performs adjustment transaction
!-- When user has current wallet balance amount information for debit device
!-- Then device has "normal" status
!-- When user activates device through helpdesk
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
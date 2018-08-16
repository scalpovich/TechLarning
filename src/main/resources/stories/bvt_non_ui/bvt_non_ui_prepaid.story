Narrative:
In order to verify the build
As an issuer
I want to run few tests

Meta:
@StoryName prepaid_cgc_manual_auth
@non_ui_bvt_prepaid

Scenario: Set up prepaid emv corporate travel card
Meta:
@non_ui_bvt_sc1
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Meta:
@non_ui_bvt_sc2
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: emv corporate gift prepaid card authorization
Meta:
@non_ui_bvt_sc3
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"


Scenario: Non-UI Verification - Event Trigger Validation
Meta:
@non_ui_bvt_sc4
Given user is logged in institution
When user is at the home tab
And user searches for alert on ui
Then EventAlertHistory page of card management tab is rendered correctly
Then verify that alert was successfully triggered
And user signs out from customer portal

Scenario:3 Non-UI Verification - Report Generation
Meta:
@non_ui_bvt_sc5
Given user is logged in institution
When user is at the home tab
Then verify report for Auth is downloaded

Scenario: Non-UI Verification - Statement Generation
Meta:
@non_ui_bvt_sc6
Given user is logged in institution
When "Statement" download batch is executed for prepaid 
Then Statement download batch is available on Batch Job History Page
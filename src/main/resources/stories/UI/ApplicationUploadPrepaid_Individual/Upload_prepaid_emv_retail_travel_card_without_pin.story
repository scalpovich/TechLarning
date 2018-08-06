Prepaid emv retail travel card multi currency with pin authorization

Narrative:
In order to check transactions on prepaid emv retail travel card
As an issuer
I want to authorize transactions for prepaid emv retail travel card

Meta:
@StoryName p_emv_retail_travel

Scenario: Set up prepaid emv retail travel card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin for ApplicationUpload
When user creates Application Upload prepaid batch file and upload it on server for Individual for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
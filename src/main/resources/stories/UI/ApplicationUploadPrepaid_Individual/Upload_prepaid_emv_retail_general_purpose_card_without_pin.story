prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general

Scenario: Set up prepaid emv retail general purpose card using ApplicationUpload
Meta:
@TestId TC398452
Given user is logged in institution
And delete dat file from Workspace
And device range for program with device plan for "prepaid" "emv" card without pin for ApplicationUpload
When user creates Application Upload prepaid batch file and upload it on server for Individual for prepaid
When processes prepaid pre-production batch
When All processes prepaid device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then delete dat file from Workspace
Then user logouts from customer portal
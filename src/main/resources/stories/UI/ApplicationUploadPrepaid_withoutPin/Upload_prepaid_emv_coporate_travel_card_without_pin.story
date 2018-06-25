prepaid emv corp travel card authorization

Narrative:
In order to check transactions on prepaid emv corp travel card
As an issuer
I want to authorize transactions for prepaid emv corp travel card

Meta:
@StoryName p_emv_corp_travel

Scenario: Set up prepaid emv corporate travel card uisng applicationUpload
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin for ApplicationUpload
When user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
When processes prepaid pre-production batch
When processes prepaid device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv corporate general purpose card
As an issuer
I want to authorize transactions for prepaid emv corporate general purpose card

Meta:
@StoryName p_emv_corp_general_purpose

Scenario: Set up prepaid emv corporate general purpose card using applicationUpload
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without dedupe
When user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And processes prepaid pin production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
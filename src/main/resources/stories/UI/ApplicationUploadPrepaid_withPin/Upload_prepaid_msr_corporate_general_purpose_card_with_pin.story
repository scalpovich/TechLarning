prepaid msr corp general purpose card authorization

Narrative:
In order to check transactions on prepaid msr corp general purpose card
As an issuer
I want to authorize transactions for prepaid msr corp general purpose card

Meta:
@StoryName p_msr_corp_general_purpose

Scenario: Set up prepaid msr corp general purpose
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
When processes prepaid pre-production batch
When processes prepaid device production batch
When processes prepaid pin production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
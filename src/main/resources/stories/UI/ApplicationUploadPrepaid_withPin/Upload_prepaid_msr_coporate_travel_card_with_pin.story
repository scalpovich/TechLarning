prepaid msr corp travel card authorization

Narrative:
In order to check transactions on prepaid msr corp travel card
As an issuer
I want to authorize transactions for prepaid msr corp travel card

Meta:
@StoryName p_msr_corp_travel


Scenario: Set up prepaid msr corporate travel card
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
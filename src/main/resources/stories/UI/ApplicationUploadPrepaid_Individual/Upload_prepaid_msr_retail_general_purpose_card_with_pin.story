prepaid msr retail general purpose card authorization

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without dedupe
When user creates Application Upload prepaid batch file and upload it on server for Individual for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And processes prepaid pin production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
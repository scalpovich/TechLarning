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
And device range for program with device plan for "prepaid" "emv" card without pin for ApplicationUpload
When user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
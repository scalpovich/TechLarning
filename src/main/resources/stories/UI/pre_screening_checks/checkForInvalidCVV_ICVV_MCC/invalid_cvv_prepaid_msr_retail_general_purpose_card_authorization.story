invalid cvv prepaid msr retail general purpose card authorization

Narrative:
In order to check invalid cvv prepaid msr retail general purpose card authorization
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose
@oldReferenceSheet_prepaid_msr
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
And user sign out from customer portal


Scenario: prepaid msr retail general purpose card device production
Meta:
@TestId TC398484
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And user sets invalid cvv/ccv2/icvv to device
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction with invalid CVV
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_CASH_ADVANCE MAS transaction
And MAS simulator is closed
And user is logged in institution
And search Cash Advance authorization and verify 183-CVV Verification Failure status
And assert Decline response with 46039 AuthDecline Code and Invalid CVV.. as description
Then user sign out from customer portal
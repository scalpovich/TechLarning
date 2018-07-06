invalid cvv prepaid msr retail general purpose card authorization

Narrative:
In order to check allow prepaid msr retail general purpose card authorization on mcc 
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
When User fills MCC Rules for prepaid product

And user sign out from customer portal


Meta:
@StoryName p_msr_retail_gen_purpose
@oldReferenceSheet_prepaid_msr
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
And user sign out from customer portal


Scenario: prepaid msr retail general purpose card device production
Meta:
@TestId TC398484
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
When user activates device through helpdesk
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Transaction
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Given user is logged in institution
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
When user edits MCC rules from 5999 to 5999 uncheck approve domestic transactions
Then user sign out from customer portal


Scenario: Transaction
When perform an MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Transaction
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal



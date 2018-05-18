ECOMM_PURCHASE transaction on prepaid msr retail general purpose card

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose
@SanityCardsWithAuthorization
@ECOM_PURCHASE

Scenario: Set up prepaid msr retail general purpose card and perform ECOMM_Purchase transaction
Meta:
@TestId TC398484

Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
When device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then a new device was created
When user processes pre-production batch for prepaid
When user processes device production batch for prepaid
Then embossing file batch was generated in correct format
Then device has "normal" status
Then user activates device through helpdesk
When connection to MAS is established
When perform an 3D_SECURE_CAVV MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal
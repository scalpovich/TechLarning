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
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card
Then user sign out from customer portal

Scenario: prepaid msr retail general purpose card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
Then user sign out from customer portal

Scenario: Device Activation and Adjustment Transaction
Given user is logged in institution
When device has "normal" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario: Transaction ECOMM Purchase
Given user is logged in institution
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
Then user sign out from customer portal
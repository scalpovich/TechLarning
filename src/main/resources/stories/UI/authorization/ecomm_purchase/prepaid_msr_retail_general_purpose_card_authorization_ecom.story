ECOMM_PURCHASE transaction on prepaid msr retail general purpose card

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose
@SanityCardsWithAuthorization

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484

Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And a new device was created
When user processes pre-production batch for prepaid
When user processes device production batch for prepaid
Then embossing file batch was generated in correct format
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
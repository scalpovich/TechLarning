3d secure prepaid msr retail general purpose card authorization with invalid cavv

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose
@oldReferenceSheet_prepaid_msr

Scenario: Set up prepaid msr retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid msr retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user sign out from customer portal
Then user is logged in institution
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Perform 3D_SECURE_INVALID_CAVV Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an 3D_SECURE_INVALID_CAVV MAS transaction
Then MAS test results are verified
And MAS simulator is closed
Given user is logged in institution
Then search E-Commerce Transaction authorization and verify 100-Do Not Honour status
Then user sign out from customer portal
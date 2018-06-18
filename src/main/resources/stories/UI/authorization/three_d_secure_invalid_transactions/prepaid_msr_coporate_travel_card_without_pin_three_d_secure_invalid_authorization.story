3d secure prepaid emv retail travel card authorization with invalid cavv

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_corp_travel
@oldReferenceSheet_S203707


Scenario: Set up prepaid msr corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
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
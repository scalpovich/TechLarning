3d secure prepaid msr retail travel purpose card authorization with invalid cavv

Narrative:
In order to a validate 3 d secure invalid Transaction on prepaid device
As a user
I want to perform 3 d secure Transaction with invalid cavv

Meta:
@StoryName p_msr_retail_travel

Scenario: Set up prepaid msr retail travel card
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card without pin
And user creates new device of prepaid type for new client
Then device has "normal" status
And user sign out from customer portal

Scenario: prepaid msr retail travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Perform 3D_SECURE_INVALID_CAVV Authorization transaction on prepaid msr retail travel card
Given connection to MAS is established
When perform an 3D_SECURE_INVALID_CAVV MAS transaction
Then MAS simulator is closed
And user is logged in institution
And search E-Commerce Transaction authorization and verify 100-Do Not Honour status
And user sign out from customer portal
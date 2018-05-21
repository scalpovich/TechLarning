3d secure Prepaid msr retail travel card multi currency without pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mc

Scenario: Setup multi-currency prepaid msr retail travel card and perfomr refund without pin authorization
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
When user updates cvccvv as uncheck on device plan
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then embossing file batch was generated in correct format
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
And user sign out from customer portal

Scenario: Perform 3D_SECURE_CAVV Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an 3D_SECURE_CAVV MAS transaction
Then MAS test results are verified
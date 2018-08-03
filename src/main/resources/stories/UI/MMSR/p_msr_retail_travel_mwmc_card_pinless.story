Prepaid msr retail travel card multi currency without pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mwmc_MMSR
@MMSR
@nitin_summarised

Scenario: Setup multi-currency prepaid msr retail travel card and perfomr refund without pin authorization
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
Then embossing file batch was generated in correct format
Then user sign out from customer portal
Then embossing file batch was generated in correct format

Scenario: Perform MMSR-RetailTravelCardMWMC Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Money Send Person To Person authorization and verify 000-Successful status
And user sign out from customer portal
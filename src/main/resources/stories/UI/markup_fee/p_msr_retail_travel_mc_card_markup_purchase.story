prepaid msr retail general purpose card

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to validate application of mark up fee for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mc	
@MSRWithoutPin

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
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
When user performs adjustment transaction
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction for second wallet
And user sign out from customer portal

Scenario: Perform PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify markup fee applied on transaction
And user sign out from customer portal
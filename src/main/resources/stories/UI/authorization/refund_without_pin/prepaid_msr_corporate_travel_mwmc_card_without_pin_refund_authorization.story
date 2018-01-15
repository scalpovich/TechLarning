Prepaid msr corporate travel card multi currency refund without pin authorization

Narrative:
In order to check transactions on prepaid msr corporate travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr corporate travel mwmc card 

Meta:
@StoryName p_emv_corp_travel_mwmc

Scenario: Setup multi-currency prepaid msr corporate travel card and perfomr refund without pin authorization
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
And user sign out from customer portal
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal
prepaid msr retail general purpose card

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to validate application of mark up fee for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mwmc

Scenario: 01. Device Creation
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: 02. Device Production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: 03. Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify Successful status
And user sign out from customer portal
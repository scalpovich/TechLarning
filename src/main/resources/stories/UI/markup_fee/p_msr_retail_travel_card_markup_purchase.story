prepaid msr retail general purpose card markup purchase

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to validate application of mark up fee for prepaid msr retail travel card 

Meta:
@StoryName p_msr_retail_travel

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
When user performs adjustment transaction with 50000 amount
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Perform INT_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_MSR_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify markup rate fee applied on transaction
And user sign out from customer portal

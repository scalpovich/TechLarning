prepaid msr retail gift card authorization PINLESS

Narrative:
In order to check transactions on prepaid msr retail gift card 
As an issuer
I want to authorize transactions for prepaid msr retail gift card 

Meta:
@StoryName p_msr_retail_gift

Scenario: Transaction - prepaid msr retail gift card - MSR_PURCHASE and MSR_PURCHASE_WITH_CASHBACK Authorization transaction
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
And user sign out from customer portal
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
When connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify Successful status
And user sign out from customer portal
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status
And user sign out from customer portal
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
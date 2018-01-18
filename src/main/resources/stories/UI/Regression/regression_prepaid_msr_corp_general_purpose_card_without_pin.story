prepaid msr corp general purpose card authorization PINLESS

Narrative:
In order to check transactions on prepaid msr corporate general purpose card 
As an issuer
I want to authorize transactions for prepaid msr corporate general purpose card 

Meta:
@StoryName p_msr_corp_general_purpose
@AuthorizationRegression
@AuthorizationRegressionGroup2

Scenario: prepaid msr corporate general purpose card > Device production - prepaid msr gift card > Perform MSR_PREAUTH and MSR_AUTH Authorization transaction > Program Balance Summary download
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
Then embossing file batch was generated in correct format
And user sign out from customer portal


Scenario: Perform MSR_PREAUTH and MSR_COMPLETION Authorization transaction
When connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Success status
And user sign out from customer portal
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_REFUND Authorization transaction
When perform an MSR_REFUND MAS transaction
Then MAS test results are verified
prepaid msr retail travel card card authorization PINLESS

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to authorize transactions for prepaid msr retail travel card 

Meta:
@StoryName p_msr_retail_travel
@AuthorizationRegression
@AuthorizationRegressionGroup1
@MSRWithoutPin

Scenario: Set up prepaid msr retail travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user sign out from customer portal

Scenario: prepaid msr retail travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction with 10000 amount
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - INT_MSR_PREAUTH  and INT_MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an INT_MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an INT_MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an INT_MSR_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_ECOMM_PURCHASE Authorization transaction
When perform an INT_ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an INT_MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_REFUND Authorization transaction
When perform an INT_MSR_REFUND MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_CASH_ADVANCE Authorization transaction
Given user is logged in institution
When user updates cvccvv as uncheck on device plan
And user sign out from customer portal
When perform an INT_MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal
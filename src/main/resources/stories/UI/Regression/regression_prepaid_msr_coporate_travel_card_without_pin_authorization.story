regression prepaid msr corporate travel card authorization PINLESS

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_corp_travel
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationRegression
@AuthorizationRegression
@AuthorizationRegressionGroup3
@MSRWithoutPin

Scenario: Set up prepaid msr corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH  and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an MSR_COMPLETION MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
When perform an MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
When perform an MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform ECOMM_PURCHASE Authorization transaction
When perform an ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_REFUND Authorization transaction
When perform an MSR_REFUND MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: MAS is closed
When MAS simulator is closed

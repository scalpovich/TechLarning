prepaid emv corporate general purpose card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate general purpose card and test various transactions

Meta:
@StoryName p_emv_corp_general_purpose
@AuthorizationRegression
@AuthorizationRegressionGroup2
@EMVWithoutPin

Scenario: Setup - prepaid emv corporate general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: Device production - prepaid emv corporate general purpose card
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
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

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: MAS is closed
When MAS simulator is closed
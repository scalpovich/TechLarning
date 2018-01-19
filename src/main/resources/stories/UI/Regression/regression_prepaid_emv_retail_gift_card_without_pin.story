prepaid emv retail giftcard card pinless authorization

Narrative:
In order to check transactions on prepaid emv retail giftcard card piness
As an issuer
I want to authorize transactions for prepaid emv retail giftcard card piness

Meta:
@StoryName S203707
@oldReferenceSheet_S203707
@AuthorizationRegression
@AuthorizationRegressionGroup3

Scenario: Set up prepaid emv retail giftcard card pinless
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status


Scenario: prepaid emv retail giftcard device production
Meta:
@TestId
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And search Pre-Auth Completion authorization and verify 000-Successful status

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Meta:
@TestId 
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify 000-Successful status

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then search Cash Advance authorization and verify 000-Successful status

Scenario: Perform EMV_REFUND Authorization transaction
Meta:
@TestId 
When perform an EMV_REFUND MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify 000-Successful status
regression prepaid emv corporate travel card authorization PINLESS

Narrative:
In order to check transactions on prepaid emv corporate debit card
As an issuer
I want to authorize transactions for prepaid emv corporate debit card

Meta:
@StoryName p_emv_corp_travel
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationRegression
@AuthorizationRegression
@AuthorizationRegressionGroup3
@EMVWithoutPinIntTrx
@InternationalTrx

Scenario: Set up prepaid emv corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction with 300000 amount
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - INT_EMV_PREAUTH and INT_EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
When perform an INT_EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_INT_EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Meta:
@TestId 
When perform an INT_INT_EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an INT_EMV_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal


Scenario: Perform INT_EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an INT_EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_ECOMM_PURCHASE Authorization transaction
When perform an INT_ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
regression prepaid emv corporate travel card authorization

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
@EMVWithPinIntTrx
@InternationalTrx

Scenario: Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - INT_EMV_PREAUTH and INT_EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an INT_EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an INT_EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_CASH_ADVANCE Authorization transaction
When perform an INT_EMV_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_POS_BALANCE_INQUIRY Authorization transaction
When perform an INT_EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_EMV_CASH_WITHDRAWAL Authorization transaction
When perform an INT_EMV_CASH_WITHDRAWAL MAS transaction on the same card
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search CWD authorization and verify 000-Successful status
And user sign out from customer portal
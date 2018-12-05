regression prepaid emv corporate travel card authorization

Narrative:
In order to check transactions on prepaid emv corporate travel card
As an issuer
I want to authorize transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationRegression
@AuthorizationRegression
@AuthorizationRegressionGroup3
@EMVWithPin

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
Then user sign out from customer portal


Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
And perform an EMV_COMPLETION MAS transaction
And MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario: 1.5 Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Given perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario:1.6 Perform EMV_CASH_ADVANCE Authorization transaction
Given perform an EMV_CASH_ADVANCE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario: 1.7 Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Given perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario: 1.8 Perform EMV_CASH_WITHDRAWAL Authorization transaction
Given perform an EMV_CASH_WITHDRAWAL MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
Then user is logged in institution
And search CWD authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal
prepaid emv retail giftcard card authorization

Narrative:
In order to check transactions on prepaid emv retail giftcard card 
As an issuer
I want to authorize transactions for prepaid emv retail giftcard card

Meta:
@StoryName S203707
@AuthorizationRegression
@AuthorizationRegressionGroup3


Scenario: Set up prepaid emv retail giftcard card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid emv retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction
When perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search CWD authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Given user is logged in institution
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
And user sign out from customer portal
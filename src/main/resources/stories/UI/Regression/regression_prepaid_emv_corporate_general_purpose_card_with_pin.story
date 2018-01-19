regression prepaid emv corporate general purpose card authorization

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate general purpose card and test various transactions

Meta:
@StoryName p_emv_corp_general_purpose
@AuthorizationRegression
@AuthorizationRegressionGroup2

Scenario: Setup - prepaid emv corporate general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client

Scenario: Device production - prepaid emv corporate general purpose card
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction - prepaid emv corporate general purpose card
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_COMPLETION Authorization transaction
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an EMV_CASH_WITHDRAWAL MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Meta:
@TestId 
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_REFUND Authorization transaction
Meta:
@TestId 
When perform an EMV_REFUND MAS transaction on the same card
Then MAS test results are verified

When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal


Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId 
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"


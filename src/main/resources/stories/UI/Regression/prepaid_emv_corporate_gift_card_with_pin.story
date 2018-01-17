prepaid emv corporate gift card with PIN

Narrative:
In order to provide a corporate client various scenarios
As an issuer
I want to create a prepaid emv corporate gift card and test various scenarios

Meta:
@StoryName p_emv_corp_gift
@AuthorizationRegression
@AuthorizationRegressionGroup2

Scenario: Setup - prepaid emv corporate gift card with PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid emv corporate gift card with PIN
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

Scenario: Pin Generation - prepaid emv corporate gift card with PIN
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction - prepaid emv corporate gift card with PIN
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Successful status
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction - prepaid emv corporate gift card with PIN
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction - prepaid emv corporate gift card with PIN
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction - prepaid emv corporate gift card with PIN
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction - prepaid emv corporate gift card with PIN
When perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Withdrawal authorization and verify Successful status
And user sign out from customer portal

Scenario: Generate Auth File for Clearing - prepaid emv corporate gift card with PIN
When Auth file is generated after transaction
When MAS simulator is closed
And user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension - prepaid emv corporate gift card with PIN
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it - prepaid emv corporate gift card with PIN
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account - prepaid emv corporate gift card with PIN
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"

Scenario: Program Balance Summary, Auth and Clearing reports download - prepaid emv corporate gift card with PIN
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
When user sign out from customer portal
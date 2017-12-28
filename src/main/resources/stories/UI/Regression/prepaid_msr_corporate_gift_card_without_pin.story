prepaid MSR corporate gift card without PIN

Narrative:
In order to provide a corporate client various scenarios
As an issuer
I want to create a prepaid MSR corporate gift card and test various scenarios

Meta:
@StoryName p_msr_corp_gift
@AuthorizationRegression
@AuthorizationRegressionGroup2

Scenario: Setup - prepaid MSR corporate gift card without PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid MSR corporate gift card without PIN
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH  and MSR_COMPLETION Authorization transaction - prepaid MSR corporate gift card without PIN
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Successful status
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction - prepaid MSR corporate gift card without PIN
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction - prepaid MSR corporate gift card without PIN
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction - prepaid MSR corporate gift card without PIN
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction - prepaid MSR corporate gift card without PIN
When perform an MSR_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Withdrawal authorization and verify Successful status
And user sign out from customer portal

Scenario: Generate Auth File for Clearing - prepaid MSR corporate gift card without PIN
When Auth file is generated after transaction
When MAS simulator is closed
And user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension - prepaid MSR corporate gift card without PIN
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it - prepaid MSR corporate gift card without PIN
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account - prepaid MSR corporate gift card without PIN
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"

Scenario: Program Balance Summary, Auth and Clearing reports download - prepaid MSR corporate gift card without PIN
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
When user sign out from customer portal
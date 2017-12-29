prepaid msr retail general purpose card authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr
@AuthorizationRegression
@AuthorizationRegressionGroup3

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId
Given user is logged in institution
When prepaid magnetic stripe device is available with balance amount
Then device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - MSR_PREAUTH Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Success status

Scenario: Transaction - MSR_COMPLETION Authorization transaction
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And search Pre-Auth Completion authorization and verify Success status

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify success status

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then search Cash Advance authorization and verify 000-Successful status

Scenario: Perform MSR_PURCHASE_WITH_REFUND Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE_WITH_REFUND MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified

Scenario: Perform ECOMM_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify success status

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed
And user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
And MCPS simulator is closed

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

Scenario: Program Balance Summary, Auth and Clearing reports download
Meta:
@TestId 
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
And user sign out from customer portal

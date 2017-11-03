debit_msr_retail_debit_card_clearing

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create a magnetic stripe retail debit card and perform transactions and clearing

Meta:
@StoryName debit_msr
@SanityCardsWithClearning
@FullSanity


Scenario: Set up retail magnetic stripe retail debit card 
Meta:
@TestId 

Given connection to FINSim is established
When user is logged in institution
When device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
When a new device was created

Scenario: Batch file Processing
Meta:
@TestId 
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: Pin Generation
Meta:
@TestId
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
When embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
When connection to MAS is established
When perform an MSR_PURCHASE_PIN MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_ADVANCE_PIN MAS transaction on the same card
Then MAS test results are verified

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

Scenario: Upload NOT file from customer portal and process it
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId TC406667
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"

Scenario: Program Balance Summary, Auth and Clearing reports download
Meta:
@TestId 
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
When user sign out from customer portal
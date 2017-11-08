Program Setup for debit emv retail debit card

Narrative:
In order to sell Debit cards
As an issuer
I want to set up a program for debit emv retail debit card

Meta:
@StoryName S190640
@SanityCardsWithClearning
@FullSanity

Scenario: Set up program for debit emv retail debit card
Meta:
@TestId TC398366
Given user is logged in institution
When User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills MCC Rules for debit product
And User fills Dedupe Plan
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And User fills Device Plan for debit product
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
Then debit device plan and program are made available for Device Creation
When user creates new device of debit type for new client
Then device has "normal" status
When user sign out from customer portal

Scenario: EMV Retail Debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
When user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
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

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId TC406665
Given user is logged in institution
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId TC406667
When in batch trace history transaction is successful
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
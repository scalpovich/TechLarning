debit emv corporate card authorisation PINLESS

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp


Scenario: Setup debit emv corp debit card 
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
And user sign out from customer portal
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

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
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
Then user sign out from customer portal
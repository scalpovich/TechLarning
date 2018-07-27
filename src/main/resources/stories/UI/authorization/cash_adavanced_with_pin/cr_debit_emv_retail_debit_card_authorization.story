debit emv retail debit card authorization PINLESS

Narrative:
In order to check transactions on debit emv retail debit card pinless
As an issuer
I want to authorize transactions for debit emv retail debit card pinless

Meta:
@StoryName d_emv_retail
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Setup - debit emv retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
Then user sign out from customer portal

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
When user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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
And user is logged in institution
And search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId 
Given user is logged in institution
When User uploads the NOT file
And user processes batch for debit
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for debit is successful
And transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal


debit msr retail debit card authorization PINLESS

Narrative:
In order to check transactions on debit msr retail debit card pinless
As an issuer
I want to authorize transactions for debit msr retail debit card pinless

Meta:
@StoryName d_msr_retail
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Setup - debit msr retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
When user updates cvccvv as uncheck on device plan
Then user sign out from customer portal

Scenario: Device production - debit msr retail debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform RECURRING_PUR_TXN Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an RECURRING_PUR_TXN MAS transaction
Then MAS test results are verified


Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
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
When user processes batch for debit
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal

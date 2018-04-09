debit msr corporate card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a msr Corporate debit card for client

Meta:
@StoryName d_msr_corp
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Setup - debit msr corp debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status
Then user sign out from customer portal

Scenario: Device production - debit msr corp debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
When user updates cvccvv as uncheck on device plan
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform RECURRING_PUR_TXN_PIN Authorization transaction
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
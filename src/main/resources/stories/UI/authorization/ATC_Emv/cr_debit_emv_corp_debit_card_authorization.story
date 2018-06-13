debit emv corporate card authorisation PIN

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Setup debit emv corp debit card 
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction with 50000 amount
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal


Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction 1
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When user notes down ATC counter on device usage screen
Then user sign out from customer portal


Scenario: Perform EMV_PURCHASE Authorization transaction 2
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal
When MAS simulator is closed

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
And a new device was created
Then device has "normal" status
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
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

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

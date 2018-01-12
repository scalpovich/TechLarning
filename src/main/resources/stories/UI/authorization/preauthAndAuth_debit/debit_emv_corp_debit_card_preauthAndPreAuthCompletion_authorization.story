debit emv corporate debit card authorization

Narrative:
In order to check transactions on debit emv corporate debit card
As an issuer
I want to authorize transactions for debit emv corporate debit card

Meta:
@StoryName d_emv_corp
@authdebit

Scenario: Transaction - corporate emv corporate general purpose card with pin - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction 
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then user sign out from customer portal

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal

When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
Then user sign out from customer portal

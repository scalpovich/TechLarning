debit emv corporate debit card authorization PINLESS

Narrative:
In order to check transactions on debit emv corporate debit card
As an issuer
I want to authorize transactions for debit emv corporate debit card

Meta:
@StoryName d_emv_corp
@authdebit

Scenario: Transaction - corporate emv emv corporate debit card without pin - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction 
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then user sign out from customer portal

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Success status
Then user sign out from customer portal

When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth Completion authorization and verify Success status
Then user sign out from customer portal
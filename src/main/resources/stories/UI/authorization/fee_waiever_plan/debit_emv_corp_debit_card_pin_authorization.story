debit emv corporate card authorisation PIN

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp

Scenario: Transaction - debit emv corp debit card - EMV_PURCHASE Authorization transaction
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
And user sign out from customer portal

Scenario: Device Production
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
And user sign out from customer portal














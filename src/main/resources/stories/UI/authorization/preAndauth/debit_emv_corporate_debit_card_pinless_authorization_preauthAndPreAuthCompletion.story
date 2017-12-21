debit emv retail debit card authorization

Narrative:
In order to check transactions on debit emv retail debit card pinless
As an issuer
I want to authorize transactions for debit emv retail debit card pinless

Meta:
@StoryName S190640
@SanityCardsPinlessWithAuthorization

Scenario: Set up debit emv retail debit card
Meta:
@TestId TC398366
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit emv retail debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk

Scenario: Transaction - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction - prepaid emv corporate general purpose card
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Success status
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth Completion authorization and verify Success status

Scenario: Program Balance Summary report download - prepaid emv corporate general purpose card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
debit emv retail debit card authorization PINLESS

Narrative:
In order to check transactions on debit emv retail debit card pinless
As an issuer
I want to authorize transactions for debit emv retail debit card pinless

Meta:
@StoryName d_emv_retail
@SanityCardsPinlessWithAuthorization

Scenario: Setup - debit emv retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status

Scenario: Transaction - EMV_PURCHASE Authorization transaction - debit emv retail debit card
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify Successful status

Scenario: Program Balance Summary report download - debit emv retail debit card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
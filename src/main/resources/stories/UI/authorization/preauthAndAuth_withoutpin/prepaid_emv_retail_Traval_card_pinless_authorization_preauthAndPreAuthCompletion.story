prepaid emv retail traval card authorization

Narrative:
In order to check transactions on prepaid emv retail traval card
As an issuer
I want to authorize transactions for prepaid emv retail traval card

Meta:
@StoryName p_emv_retail_travel

Scenario: Set up prepaid emv retail Travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid emv retail Travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction - prepaid emv retail travel card
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

Scenario: Program Balance Summary report download - prepaid emv retail travel card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
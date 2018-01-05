prepaid EMV corporate general purpose card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate general purpose card and test various transactions

Meta:
@StoryName p_emv_corp_general_purpose
Scenario: Setup - prepaid emv corporate general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: Device production - prepaid emv corporate general purpose card
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
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
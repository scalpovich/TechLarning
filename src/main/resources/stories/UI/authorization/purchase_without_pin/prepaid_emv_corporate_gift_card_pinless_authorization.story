prepaid emv corporate gift card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate gift card and test various transactions

Meta:
@StoryName p_emv_corp_gift
@SanityCards

Scenario: Setup - prepaid emv corporate gift card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: Device production - prepaid emv corporate gift card 
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk

Scenario: Transaction - EMV_PURCHASE Authorization transaction - prepaid emv corporate gift card
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify Successful status

Scenario: Transaction - EMV_PURCHASE_WITH_CASHBACK Authorization transaction - prepaid emv corporate gift card
Given connection to MAS is established
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify Successful status

Scenario: Program Balance Summary report download - prepaid emv corporate gift card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
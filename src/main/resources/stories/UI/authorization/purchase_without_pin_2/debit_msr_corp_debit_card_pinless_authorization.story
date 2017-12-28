debit msr corporate card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a msr Corporate debit card for client

Meta:
@StoryName d_msr_corp

Scenario: Setup - debit msr corp debit card
Given user is logged in institution
And device range for program with device plan for "debit" "msr" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: Device production - debit msr corp debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk

Scenario: Transaction - MSR_PURCHASE Authorization transaction - debit msr corp debit card
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify Successful status

Scenario: Transaction - MSR_PURCHASE_WITH_CASHBACK Authorization transaction - debit msr corp debit card
Given connection to MAS is established
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify Successful status

Scenario: Program Balance Summary report download - debit msr corp debit card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
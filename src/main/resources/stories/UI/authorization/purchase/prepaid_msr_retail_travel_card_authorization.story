prepaid msr retail general purpose card authorization PIN

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to authorize transactions for prepaid msr retail travel card 

Meta:
@StoryName p_msr_retail_travel
@SanityCardsWithAuthorization

Scenario: Setup - prepaid msr retail travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client

Scenario: Device production - prepaid msr retail travel card
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
When processes pin generation batch for prepaid
Then device has "normal" status
When user activates device through helpdesk

Scenario: Pin generation - prepaid msr retail travel card
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - MSR_PURCHASE_PIN Authorization transaction - prepaid msr retail travel card
When connection to MAS is established
When perform an MSR_PURCHASE_PIN MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify success status

Scenario: Transaction - MSR_PURCHASE_WITH_CASHBACK_PIN Authorization transaction - prepaid msr retail travel card
When connection to MAS is established
When perform an MSR_PURCHASE_WITH_CASHBACK_PIN MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify success status

Scenario: Program Balance Summary report download - prepaid msr retail travel card
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal
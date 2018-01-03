prepaid msr corporate gift card authorization

Narrative:
In order to check transactions on prepaid msr corporate gift card
As an issuer
I want to authorize transactions for prepaid msr corporate gift card

Meta:
@StoryName p_emv_corp_gift
@oldReferenceSheet_S203707
@CRCardsWithAuthorization

Scenario: Set up prepaid msr corporate gift card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client

Scenario: prepaid msr corporate gift card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid

Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_REFUND Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
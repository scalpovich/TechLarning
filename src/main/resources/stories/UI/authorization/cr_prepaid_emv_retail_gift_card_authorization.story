prepaid emv retail giftcard card authorization

Narrative:
In order to check transactions on prepaid emv retail giftcard card 
As an issuer
I want to authorize transactions for prepaid emv retail giftcard card

Meta:
@StoryName S203707
@CRCardsPinlessWithAuthorization

Scenario: Set up prepaid emv retail giftcard card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device

Scenario: prepaid emv retail general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
When MAS simulator is closed

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And user sign out from customer portal

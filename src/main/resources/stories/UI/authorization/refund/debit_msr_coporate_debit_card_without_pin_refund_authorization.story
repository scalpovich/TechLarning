debit msr corporate debit card authorization

Narrative:
In order to check transactions on debit msr corporate debit card
As an issuer
I want to authorize transactions for debit msr corporate debit card

Meta:
@StoryName d_emv_corp
@oldReferenceSheet_S203707
@CRCardsPinlessWithAuthorization

Scenario: Set up debit msr corporate debit card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client

Scenario: debit msr corporate debit card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

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
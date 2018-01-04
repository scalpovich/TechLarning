prepaid msr retail general purpose card authorization

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_travel
@oldReferenceSheet_prepaid_msr
@CRCardsPinlessWithAuthorization


Scenario: Set up prepaid msr retail travel card
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client

Scenario: prepaid msr retail travel card device production
Meta:
@TestId TC398484
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal


Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_CASH_ADVANCE MAS transaction
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then MAS simulator is closed

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
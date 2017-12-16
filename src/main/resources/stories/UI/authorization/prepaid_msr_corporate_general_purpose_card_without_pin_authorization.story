prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_corporate_general
@oldReferenceSheet_S203707
@CRCardsPinlessWithAuthorization

Scenario: Set up prepaid emv retail general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid emv retail general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user sign out from customer portal
Then user is logged in institution
Then device has "normal" status
When user has wallet number information for debit device
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

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
When MAS simulator is closed

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
prepaid emv retail travel card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_coprporate_travel
@oldReferenceSheet_S203707
@CRCardsPinlessWithAuthorization

Scenario: Set up prepaid emv corporate travel card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client


Scenario: prepaidemv corporate travel card device production
Meta:
@TestId TC408068
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


Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_CASH_ADVANCE MAS transaction
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search CWD authorization and verify 000-Successful status
Then user sign out from customer portal
When MAS simulator is closed

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
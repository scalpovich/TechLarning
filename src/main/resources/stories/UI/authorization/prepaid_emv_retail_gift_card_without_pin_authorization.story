prepaid emv retail giftcard card piness authorization

Narrative:
In order to check transactions on prepaid emv retail giftcard card piness
As an issuer
I want to authorize transactions for prepaid emv retail giftcard card piness

Meta:
@StoryName S203707
@oldReferenceSheet_S203707
@SanityCardsPinlessWithAuthorization

Scenario: Set up prepaid emv retail giftcard card pinless
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status


Scenario: prepaid emv retail general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device

Scenario: Perform EMV_PURCHASE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

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
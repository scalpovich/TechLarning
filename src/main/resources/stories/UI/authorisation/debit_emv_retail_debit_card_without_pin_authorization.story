debit emv retail debit card authorization

Narrative:
In order to check transactions on debit emv retail debit card pinless
As an issuer
I want to authorize transactions for debit emv retail debit card pinless

Meta:
@StoryName S190640
@SanityCardsPinlessWithAuthorization

Scenario: Set up debit emv retail debit card
Meta:
@TestId TC398366
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit emv retail debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: Perform EMV_PURCHASE Authorization transaction
Meta:

Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
Meta:
@TestId
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
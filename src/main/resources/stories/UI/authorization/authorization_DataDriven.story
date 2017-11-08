sample authorization all transactions

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization_Test
@SimulatorSession MAS

Scenario: MSR_PURCHASE transaction

When user performs an optimized <transaction> MAS transaction
Then MAS test results are verified

Examples:
|transaction|
|EMV_PURCHASE|
|EMV_POS_BALANCE_INQUIRY|
|EMV_CASH_ADVANCE|
|MSR_PURCHASE|
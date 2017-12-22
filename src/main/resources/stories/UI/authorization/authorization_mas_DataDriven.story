Independent DMS authorization 

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization_Test
@SimulatorSession MAS

Scenario: DMS transactions

When user performs an optimized <transaction> MAS transaction
Then MAS test results are verified

Examples:
|transaction|
|EMV_CASH_ADVANCE|
Independent DMS authorization Version 16.Q4

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization_Test
@SimulatorSession MAS

Scenario: DMS transactions

Given connection to MAS is established
When user performs an optimized <transaction> MAS transaction
Then MAS test results are verified

Examples:
|transaction|
|MSR_PURCHASE_WITH_CASHBACK|
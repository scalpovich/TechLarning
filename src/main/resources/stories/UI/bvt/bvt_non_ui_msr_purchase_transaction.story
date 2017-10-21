Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@NonUIBVTest
@SimulatorSession MAS

Scenario: MSR_PURCHASE transaction
When user performs an optimized <transaction> MAS transaction
Then MAS test results are verified

Examples:
|transaction|
|MSR_PURCHASE|
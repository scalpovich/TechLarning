Independent DMS authorization Version 16.Q4

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization_Test
@SimulatorSession MAS
@DataDrivenTransactions

Scenario: DMS transactions

Given connection to MAS is established
When user performs an optimized <transaction> MAS transaction
Then MAS test results are verified

Examples:
|transaction|
|ECOMM_PURCHASE|
|MSR_CASH_WITHDRAWAL|
|MSR_POS_BALANCE_INQUIRY|
|MSR_CASH_ADVANCE|
|MSR_ECOMMERCE|
|MSR_PURCHASE|
|MSR_REFUND|
|MSR_PREAUTH|
|MSR_COMPLETION|

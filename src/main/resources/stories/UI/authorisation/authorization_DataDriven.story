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
|EMV_PREAUTH|
|EMV_COMPLETION|
|MSR_POS_PURCHASE_WITH_CASHBACK|
|MSR_PREAUTH|
|MSR_COMPLETION|
|MSR_PURCHASE|
|MSR_CASH_WITHDRAWAL|
|MSR_ATM_BALANCE_INQUIRY|
|MSR_POS_BALANCE_INQUIRY|
|MSR_CASH_ADVANCE|
|MSR_ECOMMERCE|
|EMV_PURCHASE|
|EMV_CASH_WITHDRAWAL|
|EMV_ATM_BALANCE_INQUIRY|
|EMV_POS_BALANCE_INQUIRY|
|EMV_CASH_ADVANCE|
|EMV_ECOMMERCE|
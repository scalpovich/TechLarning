sample authorization all transactions

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName generate_authorization_testdata_from_datadriven_excel

Scenario: MSR_PURCHASE transaction

When user performs generate TestData for an optimized <transaction> MAS transaction

Examples:
|transaction|
|MDFS_MSR_PURCHASE_WITH_CASHBACK_PIN|
|MDFS_MSR_PURCHASE_WITH_CASHBACK	|
|MDFS_EMV_PURCHASE_WITH_CASHBACK_PIN|
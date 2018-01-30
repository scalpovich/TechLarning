sample authorization all transactions

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization_Test
@SimulatorSession MDFS

Scenario: SMS transactions

!-- Given connection to MDFS is established
When user performs an optimized <transaction> MAS transaction
Then MDFS test results are verified

Examples:
|transaction|
|MDFS_MSR_PIN_CHANGE|
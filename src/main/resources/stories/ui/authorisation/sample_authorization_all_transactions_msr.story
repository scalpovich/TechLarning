sample authorization all transactions

Narrative:
In order to perform all Authorization transaction
As an issuer
I want to perform various transaction

Meta:
@StoryName sample_authorization
@SmokeTest

Scenario: MSR_PURCHASE transaction

Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction sample
Then MAS test results are verified

Scenario: MSR_CASH_WITHDRAWAL transaction	

Given perform a sample MSR_CASH_WITHDRAWAL MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_ATM_BALANCE_INQUIRY transaction

Given perform a sample MSR_ATM_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_POS_BALANCE_INQUIRY transaction

Given perform a sample MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_CASH_ADVANCE transaction

Given perform a sample MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified

Scenario: Auth file creation

Given Auth file is generated
Then MAS simulator is closed

Scenario: Load ath file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
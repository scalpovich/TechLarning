Debit clearing: create IPM file and upload it.

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file

Meta:
@StoryName S196456
@SmokeTest

Scenario: Load ath file in MCPS and create NOT file of IPM extension
Given Auth file is generated
When connection to MCPS is established
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated

Scenario: Upload ipm file from customer portal and process it
Given user is logged in institution
When NOT file is successfully generated
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Given user is logged in institution
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"
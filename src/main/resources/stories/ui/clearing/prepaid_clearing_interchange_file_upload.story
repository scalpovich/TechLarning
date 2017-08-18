Prepaid clearing: create IPM file and upload it.

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file

Meta:
@StoryName S193887
@SmokeTest

Scenario: Load ath file in MCPS and create NOT file of IPM extension
Given Auth file is generated
When connection to MCPS is established
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated

Scenario: Upload ipm file from customer portal and process it
Given user is logged in institution
And NOT file is successfully generated
When User uploads the NOT file
And user processes batch for prepaid
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Given user is logged in institution
And in batch trace history transaction is successful
And transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then "Pre-clearing" batch for prepaid is successful
Then "EOD-Prepaid" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
And transaction fee is correctly posted

Scenario: Statement Generation
Given user is logged in institution
When "Statement" download batch is executed for prepaid 
Then file is successfully downloaded
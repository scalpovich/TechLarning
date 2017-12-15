Program Setup for debit emv retail debit card

Narrative:
In order to sell Debit cards
As an issuer
I want to set up a program for debit emv retail debit card

Meta:
@StoryName S190640
@SanityCardsWithClearning
@FullSanity

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 

When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId TC406665
Given user is logged in institution
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful
When user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId TC406667
Given user is logged in institution
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"
When user sign out from customer portal

Scenario: Program Balance Summary, Auth and Clearing reports download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
When user sign out from customer portal
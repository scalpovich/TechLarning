Prepaid authorisation: Load from file Upload and portals for prepaid emv retail gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for prepaid emv retail gift card

Meta:
@StoryName S196301
@SanityCards

Scenario: Transactions upload and processing for prepaid emv retail gift card
Meta:
@TestId TC408598
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user performs adjustment transaction
And user creates and uploads transaction file
And user processes upload batch for prepaid
Then in batch trace history transaction is successful using job id
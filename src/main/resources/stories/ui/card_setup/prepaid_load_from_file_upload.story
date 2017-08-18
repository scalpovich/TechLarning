Prepaid authorisation: Load from file Upload and portals

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file

Meta:
@StoryName S196301
@SmokeTest

Scenario: Transactions upload and processing

Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user performs adjustment transaction
And user creates and uploads transaction file
And user processes batch for prepaid
Then in batch trace history transaction is successful
Then transaction is succesful
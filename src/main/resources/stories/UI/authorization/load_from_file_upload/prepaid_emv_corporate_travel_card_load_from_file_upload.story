Prepaid authorisation: Load from file Upload and portals for prepaid emv retail gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for prepaid emv retail gift card

Meta:
@StoryName prepaid_ctc_load_from_file
@SanityCards

Scenario: Set up prepaid emv retail gift card
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid emv retail prepaid card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status

Scenario: prepaid emv adjustment and file upload transaction
Meta:
@TestId 
Given user is logged in institution
When user creates and uploads transaction file
And user processes upload batch for prepaid
Then in batch trace history transaction is successful using job id
Debit authorisation: Load from file Upload and portals for emv retail debit card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for emv retail debit card

Meta:
@StoryName debit_rdc_load_from_file
@CRCardsWithAuthorization

Scenario: Set up emv retail debit card
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: emv retail debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk

Scenario: debit emv adjustment and file upload transaction
Meta:
@TestId 
Given user is logged in institution
When user has wallet balance information for debit device
When user creates and uploads transaction file
And user processes transaction upload batch for debit
Then in batch trace history transaction is successful using job id
Then balance in helpdesk updated correctly for debit device
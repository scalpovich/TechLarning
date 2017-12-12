debit authorisation: Load from file Upload and portals for msr retail debit card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for msr retail debit card

Meta:
@StoryName debit_rdc_load_from_file
@SanityCards

Scenario: Set up msr retail debit card
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: msr retail debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status

Scenario: debit msr adjustment and file upload transaction
Meta:
@TestId 
Given user is logged in institution
When user creates and uploads transaction file
And user processes upload batch for debit
Then in batch trace history transaction is successful using job id
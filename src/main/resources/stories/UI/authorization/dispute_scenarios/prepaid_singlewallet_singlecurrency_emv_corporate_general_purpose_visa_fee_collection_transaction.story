Prepaid authorisation: Load and activate through vts and perform fee collection transaction

Narrative:
In order to perform fee collection transaction
As an issuer
I want to load and activate the visa card through vts

Meta:
@StoryName SWSC_EMV_CGP_LOAD_ACTV_VTS_NPIN
@visafeecollection_transaction

Scenario: Set up prepaid swsc emv corporate general purpose pinless card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin for an interface
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid swsc emv corporate general purpose pinless card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status

Scenario: perform visa fee collection transaction
Given user is logged in institution
When perform add visa fee Collection Fee collection Transaction [10] transaction
When user process DOWNLOAD [D] for Member Wise [D] for Generate Base II Outgoing File [VISA_OUTGOING] file
Then user validate downloaded DAT file
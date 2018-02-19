Prepaid authorisation: Load and activate from file Upload and portals for prepaid emv corporate travel card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for prepaid emv corporate travel card

Meta:
@StoryName p_mwmc_msr_ctc_load_actv_file
@CRCardsWithAuthorization

Scenario: Set up mwmc prepaid msr corporate travel card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid msr corporate prepaid card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status

Scenario: prepaid msr file upload load and activation
Meta:
@TestId 
Given user is logged in institution
When user creates and uploads transaction file
And user processes transaction upload batch for prepaid
Then batch is successful
Then device has "normal" status
And device activated and activation date is updated in general details
And user sign out from customer portal

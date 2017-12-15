Prepaid authorisation: Load from file Upload and portals for prepaid msr retail gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to Upload transactions from a file for prepaid msr retail gift card

Meta:
@StoryName S196301
@CRCardsWithAuthorization

Scenario: Set up prepaid msr retail gift card
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid msr retail prepaid card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status

Scenario: prepaid msr adjustment and file upload transaction
Meta:
@TestId 
Given user is logged in institution
When user has wallet balance information for prepaid device
When user creates and uploads transaction file
And user processes transaction upload batch for prepaid
Then in batch trace history transaction is successful using job id
Then balance in helpdesk updated correctly for prepaid device
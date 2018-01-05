Prepaid authorisation: Load and activate through vts

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to load and activate the card through vts

Meta:
@StoryName MWMC_MSR_RTC_LOAD_ACTV_VTS_NPIN
@CRCardsWithAuthorization

Scenario: Set up prepaid mwmc retail travel msr pinless card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card for an interface
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid mwmc retail travel msr pinless card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
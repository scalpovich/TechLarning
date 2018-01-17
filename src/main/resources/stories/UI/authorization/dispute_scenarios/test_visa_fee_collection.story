Prepaid authorisation: Load and activate through vts

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to load and activate the card through vts

Meta:
@StoryName SWSC_EMV_CGP_LOAD_ACTV_VTS_NPIN
@CRCardsWithAuthorization

Scenario: prepaid swsc emv corporate general purpose pinless card device production
Meta:
@TestId 
Given user is logged in institution
When perform add visa fee Collection "Fee collection Transaction [10]" transaction





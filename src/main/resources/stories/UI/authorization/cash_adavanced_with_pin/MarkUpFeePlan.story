prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up prepaid emv retail general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
When user creates a mark up fee plan
Then user sign out from customer portal
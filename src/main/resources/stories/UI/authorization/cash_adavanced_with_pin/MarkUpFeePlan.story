prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up markup fee plan
Meta:
@TestId TC398452
Given user is logged in institution
When user creates a mark up fee plan and verify it
Then user sign out from customer portal

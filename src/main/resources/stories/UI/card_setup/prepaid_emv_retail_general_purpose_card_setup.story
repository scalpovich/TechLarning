prepaid emv retail general purpose card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv retail general purpose card for client

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@SanityTest
@CardCreation

Scenario: Set up prepaid emv retail general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid emv retail general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
prepaid emv corporate giftcard card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv corporate giftcard card for client

Meta:
@StoryName p_emv_corp_gift
@oldReferenceSheet_S203707
@SanityCards

Scenario: Set up prepaid emv corporate giftcard card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without dedupe
Then prepaid device is created

Scenario: prepaid emv corporate giftcard card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When user searches for created application
When prepaid processes pre-production batch using new Application
When prepaid processes deviceproduction batch using new Application
When new Application processes pin generation batch for prepaid
Then User search for new application on search screen for prepaid and validates the status as NORMAL
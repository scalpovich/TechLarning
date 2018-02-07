prepaid virtual retail giftcard

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid virtual retail giftcard card for client

Meta:
@StoryName p_virt_retail_gift
@oldReferenceSheet_S203707
@SanityCards

Scenario: Set up prepaid virtual retail giftcard card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without dedupe
Then prepaid device is created

Scenario: prepaid virtual retail giftcard card  device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When user searches for created application
When prepaid processes pre-production batch using new Application
When prepaid processes deviceproduction batch using new Application
When new Application processes pin generation batch for prepaid
Then User search for new application on search screen for prepaid and validates the status as NORMAL
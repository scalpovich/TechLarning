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
And device range for program with device plan for "prepaid" "static virtual" card
When user creates new device of prepaid type for new client
Then device has "normal" status
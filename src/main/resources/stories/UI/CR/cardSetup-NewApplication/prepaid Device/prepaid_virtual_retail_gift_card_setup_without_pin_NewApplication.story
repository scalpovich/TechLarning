prepaid virtual retail giftcard card without pin

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid virtual retail giftcard card for client

Meta:
@StoryName p_virt_retail_gift
@oldReferenceSheet_S203707
@SanityTest
@CardCreation

Scenario: Set up prepaid virtual retail giftcard card pinless
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without pin
Then prepaid device is created
Then device has "normal" status
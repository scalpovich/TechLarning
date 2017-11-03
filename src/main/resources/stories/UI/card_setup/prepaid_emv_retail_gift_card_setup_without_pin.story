prepaid emv retail giftcard card pinless setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv retail giftcard card without pin for client

Meta:
@StoryName S203707
@oldReferenceSheet_S203707
@SanityCards

Scenario: Set up prepaid emv retail giftcard card pinless
Meta:
@TestId TC398452
Given user is logged in institution
And prepaid emv device without pin is available with balance amount
And user has current wallet balance amount information for prepaid device
And user sign out from customer portal
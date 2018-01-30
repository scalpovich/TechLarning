prepaid emv retail gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv retail giftcard card for client

Meta:
@StoryName S203707
@SanityCards


Scenario: Set up prepaid emv retail giftcard
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
Then prepaid device is created

Scenario: prepaid emv retail giftcard device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
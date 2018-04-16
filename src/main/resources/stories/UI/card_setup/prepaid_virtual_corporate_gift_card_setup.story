prepaid virtual corporate gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual corporate gift card prepaid card for client

Meta:
@StoryName S247705
@SanityCards
@UISanity

Scenario: Set up prepaid virtual corporate gift card
Meta:
@TestId TC407307
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card
When user creates new device of prepaid type for new client
Then device has "normal" status
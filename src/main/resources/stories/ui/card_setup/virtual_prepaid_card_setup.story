Virtual prepaid Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual prepaid card for client

Meta:
@StoryName S247705
@SmokeTest

Scenario: Set up virtual prepaid card

Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card
When user creates new device of prepaid type for new client
Then device has "normal" status

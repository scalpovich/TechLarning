Virtual Debit Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual debit card for client

Meta:
@StoryName S198219
@SmokeTest

Scenario: Set up virtual debit card

Given user is logged in institution
And device range for program with device plan for "debit" "static virtual" card
When user creates new device of debit type for new client
Then device has "normal" status

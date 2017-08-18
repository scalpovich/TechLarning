Retail Magnetic Stripe Debit Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a retail magnetic stripe debit card for client

Meta:
@StoryName S198220
@SmokeTest

Scenario: Set up retail magnetic stripe debit card

Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: retail magnetic stripe debit card device production and authorization

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
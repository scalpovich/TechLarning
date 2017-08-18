ATM admin Debit Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a ATM admin debit card for client

Meta:
@StoryName S224289
@SmokeTest

Scenario: Set up ATM admin debit card

Given user is logged in institution
And device range for program with device plan for "debit" "ATM admin" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: ATM admin debit card device production and authorization

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
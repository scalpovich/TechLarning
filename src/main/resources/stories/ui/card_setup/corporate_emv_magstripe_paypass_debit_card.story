Corporate EMV magnetic Stripe Pay-Pass debit card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a corporate EMV magnetic stripe pay-pass debit card

Meta:
@StoryName S224288
@SmokeTest

Scenario: Set up Corporate EMV magnetic Stripe Pay-Pass debit card 

Given user is logged in institution
And device range for program with device plan for "debit" "EMV Paypass" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: Corporate EMV magnetic Stripe Pay-Pass debit card device production and authorization

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
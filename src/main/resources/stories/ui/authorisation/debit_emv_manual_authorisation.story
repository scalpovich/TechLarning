EMV Debit Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an emv debit card for client

Meta:
@StoryName S198222
@SmokeTest

Scenario: Set up emv debit card

Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status


Scenario: emv debit card device production and authorization

Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status


Scenario: emv debit card authorization

Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
EMV corporate debit card manual authorization

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an emv debit card for client and perform manual authorization from customer portal

Meta:
@StoryName debit_cdc_manual_auth
@NonUIBVTest
@CRCardsWithAuthorization

Scenario: Set up emv corporate debit card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: emv debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status

Scenario: emv debit card authorization
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
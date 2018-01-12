MSR retail debit card manual authorization

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an msr debit card for client and perform manual authorization from customer portal

Meta:
@StoryName S198222
@NonUIBVTest
@CRCardsWithAuthorization

Scenario: Set up msr retail debit card
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: msr debit card device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status

Scenario: msr debit card authorization
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
prepaid corporate gift static virtual card manual authorization

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an svc prepaid card for client and perform manual authorization from customer portal

Meta:
@StoryName prepaid_cgc_manual_auth
@CRCardsWithAuthorization

Scenario: Set up svc prepaid card
Meta:
@TestId TC407061
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: svc prepaid card device production
Meta:
@TestId TC408234
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status

Scenario: svc prepaid card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
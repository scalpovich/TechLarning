prepaid retail gift card emv manual authorization

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an emv prepaid card for client and perform manual authorization from customer portal

Meta:
@StoryName prepaid_rgc_manual_auth
@CRCardsWithAuthorization

Scenario: Set up emv retail gift prepaid card
Meta:
@TestId TC407061
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: emv retail gift prepaid card device production
Meta:
@TestId TC408234
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk

Scenario:emv retail gift prepaid card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
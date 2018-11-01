prepaid retail travel card msr manual authorization

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create an msr prepaid card for client and perform manual authorization from customer portal

Meta:
@StoryName prepaid_rtc_manual_auth
@CRCardsWithAuthorization

Scenario: Set up msr retail travel prepaid card
Meta:
@TestId TC407061
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status
And user signs out from customer portal

Scenario: msr retail travel prepaid card device production
Meta:
@TestId TC408234
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
And user signs out from customer portal

Scenario: msr retail travel prepaid card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"
And user signs out from customer portal
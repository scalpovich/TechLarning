Retail Magnetic Stripe prepaid Card Setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a retail general purpose magnetic stripe preapid card for client

Meta:
@StoryName S203706
@SanityTest
@CardCreation

Scenario: Set up retail magnetic stripe preapid card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: retail magnetic stripe preapid card device production and authorization
Meta:
@TestId TC398484
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
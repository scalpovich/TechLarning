debit msr retail debit card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a retail magnetic stripe debit card for client

Meta:
@StoryName S198220
@SanityCards

Scenario: Setup debit msr retail debit card
Meta:
@TestId TC398503
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit msr retail debit card device production
Meta:
@TestId TC408321
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
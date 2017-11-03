debit msr retail debit card pinless setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a EMV Retail Debit debit card for client

Meta:
@StoryName S190640
@SanityCards

Scenario: Set up debit msr retail debit card pinless
Meta:
@TestId TC398366

Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit msr retail debit card pinless device production
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
debit virtual retail card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual retail debit card for client

Meta:
@StoryName S198219
@SanityTest
@CardCreation


Scenario: Set up debit virtual retail card
Meta:
@TestId TC398504
Given user is logged in institution
And device range for program with device plan for "debit" "static virtual" card
When user creates new device of debit type for new client
Then device has "normal" status

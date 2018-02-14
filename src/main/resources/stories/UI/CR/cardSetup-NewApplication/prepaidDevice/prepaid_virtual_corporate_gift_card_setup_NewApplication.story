prepaid virtual corporate gift card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual corporate gift card prepaid card for client

Meta:
@StoryName S247705
@SanityCards

Scenario: Set up prepaid virtual corporate gift card
Meta:
@TestId TC407307
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without dedupe
Then prepaid device is created

Scenario: prepaid virtual corporate gift card
Meta:
@TestId 
Given user is logged in institution
And a new device was created
When user searches for created application
When prepaid processes pre-production batch using new Application
Then User search for new application on search screen for prepaid and validates the status as NORMAL
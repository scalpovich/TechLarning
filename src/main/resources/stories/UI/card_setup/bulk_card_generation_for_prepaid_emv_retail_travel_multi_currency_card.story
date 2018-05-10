bulk card generation for prepaid emv retail travel multi currency card

Narrative:
In order to create prepaid cards in bulk
As an issuer
I want to create a bulk card request and generate cards for or prepaid emv retail travel multi currency card

Meta:
@StoryName S280665
@SanityCards
@UISanity

Scenario: bulk card generation for prepaid emv retail travel multi currency card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates a bulk device production request for prepaid
And processes created bulk device generation request for prepaid
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid

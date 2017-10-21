bulk card generation for prepaid emv retail gift card

Narrative:
In order to create prepaid cards in bulk
As an issuer
I want to create a bulk card request and generate cards for prepaid emv retail gift card

Meta:
@StoryName S193810
@SanityTest
@author NidhiVyas
@CardCreation


Scenario: bulk card generation for prepaid emv retail gift card
Meta:
@TestId TC398392
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates a bulk device production request for prepaid
And processes created bulk device generation request for prepaid
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
Then pin offset file is generated sucessfully for prepaid
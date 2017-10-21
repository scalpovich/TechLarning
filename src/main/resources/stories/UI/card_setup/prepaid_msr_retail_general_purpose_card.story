prepaid msr retail general purpose card

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName p_msr_retail_gen_purpose
@oldReferenceSheet_prepaid_msr
@SanityTest
@Authorisation

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid msr retail general purpose card device production
Meta:
@TestId TC398484
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
prepaid msr retail general purpose card pinless setup

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr
@SanityCards

Scenario: Set up prepaid msr retail general purpose card pinless
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
Then prepaid device is created

Scenario: prepaid msr retail gift card authorization pinless device production
Meta:
@TestId TC408068
Given user is logged in institution
When user searches for created application
When prepaid processes pre-production batch using new Application
When prepaid processes deviceproduction batch using new Application
When new Application processes pin generation batch for prepaid
Then User search for new application on search screen for prepaid and validates the status as NORMAL
prepaid virtual retail general purpose card authorization

Narrative:
In order to check transactions on prepaid virtual retail general purpose card
As an issuer
I want to authorize transactions for prepaid virtual retail general purpose card

Meta:
@StoryName p_virt_retail_general_purpose
@oldReferenceSheet_S203707
@SanityCardsWithAuthorization

Scenario: Set up prepaid virtual retail general purpose card
Meta: 
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid virtual retail general purpose card device production
Meta:
@TestId TC398484
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device

Scenario: Perform ECOMMERCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_ECOMMERCE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
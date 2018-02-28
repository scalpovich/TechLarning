debit virtual retail authorization

Narrative:
In order to check transactions on debit virtual retail card pinless
As an issuer
I want to authorize transactions for debit virtual retail card pinless

Meta:
@StoryName S198219
@SanityCardsPinlessWithAuthorization

Scenario: Set up debit virtual retail card
Meta:
@TestId TC398504
Given user is logged in institution
And device range for program with device plan for "debit" "static virtual" card
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit virtual retail card device production
Meta:
@TestId TC408321
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
!-- When processes device production batch for debit
Then device has "normal" status

Scenario: Perform MSR_ECOMMERCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_ECOMMERCE MAS transaction
Then MAS test results are verified
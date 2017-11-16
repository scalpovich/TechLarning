debit virtual retail card authorization

Narrative:
In order to check transactions on debit virtual retail card
As an issuer
I want to authorize transactions for debit virtual retail card

Meta:
@StoryName S198219
@SanityCardsWithAuthorization


Scenario: Set up debit virtual retail card
Meta:
@TestId TC398504
Given user is logged in institution
And device range for program with device plan for "debit" "static virtual" card
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform ECOMMERCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_ECOMMERCE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
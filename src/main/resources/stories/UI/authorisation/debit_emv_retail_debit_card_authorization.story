debit emv retail debit card authorization

Narrative:
In order to check transactions on debit emv retail card
As an issuer
I want to authorize transactions for debit emv retail debit card

Meta:
@StoryName S190640
@SanityCardsWithAuthorization

Scenario: Set up program for debit emv retail debit card
Meta:
@TestId TC398366
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: debit emv retail debit card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_ECOMMERCE Authorization transaction
Meta:
@TestId 
When perform an EMV_ECOMMERCE MAS transaction
Then MAS test results are verified

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId
When perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
When MAS simulator is closed
debit msr retail debit card authorization

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create a magnetic stripe retail debit card and perform transactions

Meta:
@StoryName debit_msr
@SanityCardsWithAuthorization

Scenario: Set up retail magnetic stripe retail debit card 
Meta:
@TestId TC406726

Given user is logged in institution
When device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: retail magnetic stripe retail debit card device production 
Meta:
@TestId

Given user is logged in institution
And a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
Then device has "normal" status

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
When embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
When connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_ECOMMERCE Authorization transaction
Meta:
@TestId 
When perform an MSR_ECOMMERCE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId 
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
When MAS simulator is closed
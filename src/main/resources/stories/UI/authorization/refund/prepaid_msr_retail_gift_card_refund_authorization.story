prepaid msr retail general purpose card authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName p_emv_retail_gift
@oldReferenceSheet_prepaid_msr
@SanityCardsWithAuthorization

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC406658
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId 
When connection to MAS is established
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction
Then MAS test results are verified
When MAS simulator is closed

Narrative:
In order to test transaction with invalid pin and reset pin retry counter
As an issuer
I want to perform transactions for debit emv card

Meta:
@StoryName d_emv_corp
@pinRetryLimitValidationAndResetCounter

Scenario: Setup - debit emv corporate card with PIN
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then user sign out from customer portal

Scenario: Device production - debit emv corporate card with PIN
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
And user set invalid pin
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 117-Incorrect PIN status
And assert Decline response with 46051 AuthDecline Code and Incorrect Pin. as description
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction for pin retry limit check
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 106-Allowable Pin tries exceeded status
And assert Decline response with 46053 AuthDecline Code and Pin retry limit exceeded. as description
And device has "normal" status
And user reset pin retry counter Reset Pin Retry Counter [109]
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then PIN is retrieved successfully with data from Pin Offset File

Scenario: Perform EMV_PURCHASE Authorization transaction with valid pin
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And FINSim simulator is closed
And MAS simulator is closed

Narrative:
In order to check transaction without balance in emv corporate travel card
As an issuer
I want to failed transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel

Scenario: Setup - prepaid emv corporate travel card with PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid emv corporate travel card with PIN
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File
And embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 116-Insufficient Fund status
And assert Decline response with 46017 AuthDecline Code and Insufficient fund available. as description
And user sign out from customer portal
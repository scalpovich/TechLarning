Narrative:
In order to test transaction plan without assigned transaction for prepaid emv corporate travel card
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
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
When embossing file batch was generated in correct format
When user set invalid pin
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then device has "normal" status
When user reset pin retry counter Reset Pin Retry Counter [109]
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed


Scenario: Perform EMV_PURCHASE Authorization transaction with valid pin
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@Pre-ScreeningCheck
@StoryName p_emv_corp_travel				 

Scenario: Set up prepaid emv corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
When User enter incorrect Expiry Date

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 101-EXPIRED CARD status
Then assert Decline response with 20005 AuthDecline Code and Device is expired. as description
And user sign out from customer portal
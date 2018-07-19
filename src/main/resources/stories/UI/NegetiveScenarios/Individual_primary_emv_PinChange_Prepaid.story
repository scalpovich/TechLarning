Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@PreScreening
@StoryName p_emv_corp_travel				 

Scenario: Set up prepaid emv corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user sign out from customer portal

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
When User checks Pin Change Transaction First check box on Device Plan Page
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then assert Decline response with 46010 AuthDecline Code and Tranaction is not Pin change. as description
And user sign out from customer portal

Scenario: Credit Corporate- Pin Change Transaction
Then connection to MDFS is established
When user performs an optimized MDFS_EMV_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
Given user is logged in institution
Then search Pin Change authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform Second EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When PIN is created for Pin Change First Transaction
When perform an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal
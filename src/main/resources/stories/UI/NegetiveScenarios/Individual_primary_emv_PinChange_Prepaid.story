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
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user has wallet number information for prepaid device
And user sign out from customer portal
And user is logged in institution
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And User checks Pin Change Transaction First check box on Device Plan Page
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

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
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@PreScreening
@StoryName p_emv_corp_travel				 

Scenario: Set up prepaid emv corporate travel card
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card
Then user creates new device of prepaid type for new client
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
And user selects International Use Allow/Disallow status
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 119-Transaction not permitted status
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal

Scenario: Perform International Allow/DisAllow for one hour
Given user is logged in institution
When user allow International Use Allow/Disallow [400] Transaction For One Hour
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Wait for 1 hour and Then Perform Purchase Transaction
When user wait for one hour to perform transaction
And perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal
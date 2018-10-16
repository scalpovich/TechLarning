Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate Prepaid card and assert application block/unblock priority check.

Meta:
@StoryName p_emv_corp_travel				 

Scenario:1.1 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "prepaid" "emv" card for issuer scripting
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario:1.2 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
And user sign out from customer portal

Scenario:1.3 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
And user sign out from customer portal

Scenario:1.4 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.5 Transaction EMV_PURCHASE Application block
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.6 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as NULL
And Verify APPLICATION_UNBLOCK_ICC has column value as NULL

Scenario:1.7 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
And user sign out from customer portal

Scenario:1.8 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
And user sign out from customer portal

Scenario:1.9 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:2.0 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as Non Null
And Verify APPLICATION_UNBLOCK_ICC has column value as NULL

Scenario:2.1 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal

Scenario:2.2 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as NULL
Then Verify APPLICATION_UNBLOCK_ICC has column value as Not null

Scenario:2.3 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal
And MAS simulator is closed

Scenario:2.4 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as NULL
Then Verify APPLICATION_UNBLOCK_ICC has column value as NULL
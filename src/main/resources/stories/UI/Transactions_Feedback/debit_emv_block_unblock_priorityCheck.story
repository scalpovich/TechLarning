Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate debit card to assert application block/unblock priority check.

Meta:
@StoryName d_emv_corp				 

Scenario:1 Set up debit emv corporate travel card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "debit" "emv" card for issuer scripting
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario:2 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario:3 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then user sign out from customer portal

Scenario:4 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:5 Transaction EMV_PURCHASE Application block
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:6 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as null
Then Verify APPLICATION_UNBLOCK_ICC has column value as null

Scenario:7 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario:8 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then user sign out from customer portal

Scenario:9 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:10 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as not null
Then Verify APPLICATION_UNBLOCK_ICC has column value as null

Scenario:11 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal

Scenario:12 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as null
Then Verify APPLICATION_UNBLOCK_ICC has column value as not null

Scenario:13 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal
And MAS simulator is closed

Scenario:14 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as null
Then Verify APPLICATION_UNBLOCK_ICC has column value as null
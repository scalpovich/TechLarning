credit Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for credit mastercard_individual_primary_emv card 
when application is in block or unblock mode

Meta:
@StoryName cr_emv_issuer_scripting_app_block_unblock_negative
@IssuerScript
Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And User fills Device Plan for "credit" "emv" card for issuer scripting
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal

Scenario:1.2 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario:1.3 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then user sign out from customer portal

Scenario:1.4 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.5 Transaction EMV_PURCHASE Application block
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:6 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as Null
Then Verify APPLICATION_UNBLOCK_ICC has column value as Null

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
Given Verify APPLICATION_BLOCK_ICC has column value as Not Null
Then Verify APPLICATION_UNBLOCK_ICC has column value as Null

Scenario:11 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal

Scenario:12 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as Not Null
Then Verify APPLICATION_UNBLOCK_ICC has column value as Not Null

Scenario:13 Transaction of EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal
And MAS simulator is closed

Scenario:14 Verify DB has value in Application Unblock Column
Given Verify APPLICATION_BLOCK_ICC has column value as Null
Then Verify APPLICATION_UNBLOCK_ICC has column value as Null
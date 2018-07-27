 debit Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for debit emv corporate debit card
when application is in block or unblock mode

Meta:
@StoryName d_emv_issuer_scripting_app_block_unblock
@IssuerScript
Scenario: Set up program for debit emv corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "debit" "emv" card for issuer scripting
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device

Scenario: debit msr corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
Then user activates device through helpdesk

Scenario: Add the device into stoplist
When user is logged in institution
When user stoplists a card from stoplist device screen
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction EMV_PURCHASE and EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
When user is logged in institution
Then assert Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
And user sign out from customer portal
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
When user is logged in institution
Then assert Success [0] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
And user sign out from customer portal

Scenario: Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then user sign out from customer portal

Scenario: Transaction EMV_PURCHASE and EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application unblock
When perform an EMV_PURCHASE MAS transaction on the same card
When user is logged in institution
Then assert Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
Then MAS simulator is closed
When user is logged in institution
Then assert Success [0] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
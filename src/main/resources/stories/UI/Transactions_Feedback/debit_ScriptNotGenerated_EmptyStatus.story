Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate debit card to assert application block/unblock priority check.

Meta:
@StoryName d_emv_corp_applicationunblock_emptystatus				 

Scenario:1.1 Set up debit emv corporate travel card
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
And user sets invalid pin
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
Then user sign out from customer portal

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then verify Empty status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 117-Incorrect PIN status
And assert Decline response with 46051 AuthDecline Code and Incorrect Pin. as description
Then user sign out from customer portal

Scenario:1.5 Verify DB has value in Application Unblock Column
Then Verify APPLICATION_UNBLOCK_ICC has column value as Null

Scenario:1.6 Perform EMV_PURCHASE Authorization transaction for pin retry limit check
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 106-Allowable Pin tries exceeded status
And assert Decline response with 46053 AuthDecline Code and Pin retry limit exceeded. as description
And device has "normal" status
And user creates service request for Pin Retry Counter [109] service
Then user sign out from customer portal

Scenario:1.7 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.8 Transaction EMV_PURCHASE Application block
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then verify Empty status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed

Scenario:1.9 Verify DB has value in Application Unblock Column
Then Verify APPLICATION_UNBLOCK_ICC has column value as Null
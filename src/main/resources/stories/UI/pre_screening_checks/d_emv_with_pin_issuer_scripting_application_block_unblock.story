 debit Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for debit emv corporate debit card
when application is in block or unblock mode

Meta:
@StoryName d_emv_issuer_scripting_app_block_unblock

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
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
Then user sign out from customer portal


Scenario: Add the device into stoplist
Given user is logged in institution
When user stoplists a card from stoplist device screen
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction EMV_PURCHASE
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
Then assert Purchase response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
And user sign out from customer portal
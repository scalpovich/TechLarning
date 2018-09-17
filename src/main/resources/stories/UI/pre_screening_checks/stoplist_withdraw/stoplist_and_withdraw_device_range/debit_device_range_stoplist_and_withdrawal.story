!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a debit device  
so that the user's device range can be stoplisted and stoplist withdrawal

Meta:
@StoryName d_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario:1 Setup - debit emv retail debit card
Given user is logged in institution
When device range for program with device plan for "debit" "emv" card without pin
Then user creates new device of debit type for new client
And user sign out from customer portal

Scenario:2 Device production - debit emv retail debit card
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:3 To Verify that the user can stoplist device range of debit card
Given user is logged in institution
When user stoplists a device range from stoplist device range screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:4 Transaction - EMV_PREAUTH Authorization transaction on debit card after stoplisted device range
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 207-PICK-UP CARD status
Then assert Capture response with 27001 AuthDecline Code and Device range is stoplisted. as description
And user sign out from customer portal

Scenario:5 To Verify that the user can withdraw stoplist device range of debit card
Given user is logged in institution
When user withdraws a device range from withdraw device range screen
Then user sign out from customer portal

Scenario:6 Transaction - EMV_PREAUTH Authorization transaction on debit card after withdrawn device range
Given perform an EMV_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
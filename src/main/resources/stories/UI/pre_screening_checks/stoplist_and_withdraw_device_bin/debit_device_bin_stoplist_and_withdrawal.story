!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device bin 
so that the user's device bin can be stoplisted and stoplist withdrawal

Meta:
@StoryName d_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario:1 Setup - debit emv retail debit card
Given user is logged in institution
When device range for program with device plan for "debit" "emv" card without pin
Then user creates new device of debit type for new client

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
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:3 To Verify that the user can stoplist device bin of debit device
Given user is logged in institution
When user stoplists a device bin from stoplist device bin screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:4 Transaction - EMV_PREAUTH Authorization transaction on debit device after stoplisted device bin
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 207-PICK-UP CARD status
And assert Capture response with 27002 AuthDecline Code and Bin is stoplisted. as description
Then user sign out from customer portal

Scenario:5 To Verify that the user can withdraw stoplist device bin of credit device
Given user is logged in institution
When user withdraws a device Bin from withdraw device Bin screen
Then user sign out from customer portal

Scenario:6 Transaction - EMV_PREAUTH Authorization transaction on debit device after withdrawn device bin
Given perform an EMV_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
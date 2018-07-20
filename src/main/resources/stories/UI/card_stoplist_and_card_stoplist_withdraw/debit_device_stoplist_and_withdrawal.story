!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a debit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@StoryName d_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario: Setup - debit emv retail debit card
Given user is logged in institution
When device range for program with device plan for "debit" "emv" card without pin
Then user creates new device of debit type for new client

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario:To Verify that the user can stoplist debit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And edit deviceplan and enable stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH Authorization transaction on debit device after stoplisted device
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 207-PICK-UP CARD status
And assert Capture response with 27000 AuthDecline Code and Device is stoplisted. as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist debit device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then device has "normal" status
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on debit device after withdrawn device
Given perform an EMV_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
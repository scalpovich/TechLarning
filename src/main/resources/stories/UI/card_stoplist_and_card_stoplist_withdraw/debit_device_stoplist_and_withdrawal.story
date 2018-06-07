!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@StoryName d_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario: Setup - debit emv retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal

Scenario:To Verify that the user can stoplist device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
Then device has "lost" status
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then device has "normal" status
Then user sign out from customer portal
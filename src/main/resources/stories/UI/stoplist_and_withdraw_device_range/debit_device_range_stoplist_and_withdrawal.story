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
When embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:To Verify that the user can stoplist device range of debit card
Given user is logged in institution
When user stoplists a device range from stoplist device range screen
When edit deviceplan and enable stoplist flag
Then user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH Authorization transaction on debit card after stoplisted device range
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS simulator is closed
Given user is logged in institution
Then search Pre-Auth authorization and verify 207-PICK-UP CARD status
Then assert Capture response with 27001 AuthDecline Code and Device range is stoplisted. as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device range of debit card
Given user is logged in institution
When user withdraws a device range from withdraw device range screen
Then user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH Authorization transaction on debit card after withdrawn device range
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
Then MAS simulator is closed
Given user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
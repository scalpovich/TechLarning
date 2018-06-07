!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@StoryName prepaid_msr_retail_gift_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario: Set up prepaid msr retail gift card authorization pinless
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user sign out from customer portal

Scenario: prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario:To  Verify that the user can stoplist device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
Then device has "lost" status
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then device has "normal" status
Then user sign out from customer portal


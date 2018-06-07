!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal

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
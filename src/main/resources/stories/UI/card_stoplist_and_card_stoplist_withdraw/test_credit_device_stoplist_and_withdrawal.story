!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can stoplist card from stoplist screen
Given user is logged in institution
When user stoplists a card from stop list device screen
Then device has "lost" status
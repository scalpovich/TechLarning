!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a prepaid device  
so that the user device can be stoplisted and stoplist withdrawal

Meta:
@StoryName prepaid_msr_retail_gift_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario: Set up prepaid msr retail gift card authorization pinless
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
And user sign out from customer portal

Scenario: prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And device has "normal" status
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:To  Verify that the user can stoplist prepaid device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enable stoplist flag
Then device has "lost" status
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid device after stoplisted device
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 208-LOST CARD, PICK-UP status
And assert Capture response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist prepaid device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then device has "normal" status
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid device after withdrawn device
Given perform an MSR_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a prepaid device country  
so that the user's device country can be stoplisted and stoplist withdrawal

Meta:
@StoryName prepaid_msr_retail_gift_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario:1 Set up prepaid msr retail gift card authorization pinless
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario:2 prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal


Scenario:To Verify that the user can stoplist device country of prepaid device
Given user is logged in institution
When user stoplists a country from stoplist country screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid device after stoplisted device country
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 100-Do Not Honour status
And assert Decline response with 27003 AuthDecline Code and Country is stoplisted. as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device country of prepaid device
Given user is logged in institution
When user withdraws a country from withdraw country screen
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid device after withdrawn device country
Given perform an MSR_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
!-- @author: E074127
Narrative:
As a Customer portal user
I want to stoplist and withdraw stoplist a debit device  
so that the user can verify the stoplist functionality

Meta:
@StoryName debit_stoplist_helpdesk
@helpdeskStoplistDebit

Scenario:1 creation of mastercard emv card debit device
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for debit product
And User fills MCC Rules for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
Then user creates new device of debit type for new client
And user sign out from customer portal

Scenario:2 To Verify that the user can stoplist a debit device through helpdesk
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And device has "normal" status
And user activates device through helpdesk
And user stop lists the device
And user edits deviceplan and enables stoplist flag
Then device has "lost" status
And user sign out from customer portal

Scenario:3 Transaction - Verify that the transaction declines with appropriate response for stoplisting
Given user is logged in institution
When user raises an authorization request
And status of request is declined with reason Lost
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
Then assert Capture response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
And user sign out from customer portal

Scenario:4 Transaction - Verify that the user is able to make a successful transaction on the withdrawaing the stoplisting
Given user is logged in institution
When user withdraws the stoplisted device
And user raises an authorization request
Then status of request is declined with reason Lost
And user sign out from customer portal


!-- @author: E074127
Narrative:
As a Customer portal user
I want to stoplist and withdraw stoplist a prepaid device  
so that the user can verify the stoplist functionality

Meta:
@StoryName stoplist_helpdesk_prepaid
@helpdeskStoplistPrepaid

Scenario:1 creation of mastercard_individual_primary_emv Card prepaid device
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario:2 To Verify that the user can stoplist a prepaid device through helpdesk
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
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
Then user raises an authorization request
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal


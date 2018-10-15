!-- @author: E074127
Narrative:
As a Customer portal user
I want to stoplist and withdraw stoplist a prepaid device  
so that the user can verify the stoplist functionality

Meta:
@StoryName stoplist_helpdesk_prepaid_visa
@helpdeskStoplistPrepaidVisa

Scenario: 1 Set up prepaid retail general purpose card
Given setting json values in excel for Prepaid
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for prepaid product for Visa
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User Primary Device fills New Program Retail General Purpose Card [4] section for prepaid product for Visa
And for Primary Device and New Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card [1]
Then user sign out from customer portal

Scenario:2 To Verify that the user can stoplist a prepaid device through helpdesk
Given user is logged in institution
When a new device was created
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user assigns service code to program
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
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

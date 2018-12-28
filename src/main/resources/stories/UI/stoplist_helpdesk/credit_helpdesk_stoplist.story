!-- @author: E074127
Narrative:
As a Customer portal user
I want to stoplist and withdraw stoplist a credit device  
so that the user can verify the stoplist functionality

Meta:
@StoryName stoplist_helpdesk_credit
@helpdeskStoplistCredit

Scenario:1 creation of mastercard_Retail Credit Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And user saves the fees applied for Stoplist Withdrawal Fee on device based event fee plan for Normal card
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And user sign out from customer portal

Scenario:2 To Verify that the user can stoplist a credit device through helpdesk
Given user is logged in institution
When credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user stop lists the device
And user edits deviceplan and enables stoplist flag
Then device has "lost" status
And user sign out from customer portal

Scenario:3 Transaction - Verify that the transaction declines with appropriate response for stoplisting
Given user is logged in institution
When embossing file batch was generated in correct format
And user raises an authorization request only
And status of request is declined with reason LOST
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
Then assert Capture response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
And user sign out from customer portal

Scenario:4 Transaction - Verify that the user is able to make a successful transaction on the withdrawaing the stoplisting
Given user is logged in institution
When user withdraws the stoplisted device
Then user raises an authorization request only
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:5 Post maintenance batch and pre-clearing batch is run
Given user is logged in institution
When post maintenance batch is run
And user processes Pre-clearing system internal batch for Credit
Then user sign out from customer portal

Scenario:6 To verify that the device event fee for card renewal - credit is deducted
Given user is logged in institution
When verify that the device event fees for Stoplist Withdrawal Fee is levied for Normal card
Then user signs out from customer portal
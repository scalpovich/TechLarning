!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the users device can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_corporate_stoplist_withdraw
@CardStoplistAndWithdrawal
		 
Scenario:1 creation of mastercard corporate credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
And user sign out from customer portal

Scenario:2 Card boarding batches - credit
Given user is logged in institution
When credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario:3 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "expired" status
Then user sign out from customer portal

Scenario:4 Transaction - Verify that the transaction declines with appropriate response for stoplisting
Given user is logged in institution
When user raises an authorization request
And status of request is declined with reason Expired
And search Purchase authorization and verify 101-EXPIRED CARD status
And assert Decline response with 70123 AuthDecline Code and Card Status is Expired with Decline Response as description
Then user sign out from customer portal

Scenario:5 To Verify that the user can withdraw stoplist credit device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
And device has "normal" status
Then user sign out from customer portal

Scenario:4 Transaction - Verify that the user is able to make a successful transaction on the withdrawaing the stoplisting
Given user is logged in institution
When user raises an authorization request
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal


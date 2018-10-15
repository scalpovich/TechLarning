!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the users device can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_not_delivered_emv_retail_stoplist_withdraw_visa
@CardStoplistAndWithdrawalVisa
		 
Scenario: 1 Set up retail credit card
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills Device Plan for credit product for Visa
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
Then user sign out from customer portal

Scenario:2 Card boarding batches - credit
Given user is logged in institution
When credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario:3 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario:4 Transaction - Verify that the transaction declines with appropriate response for not delivered
Given user is logged in institution
When user raises an authorization request
And status of request is declined with reason Not delivered
And search Purchase authorization and verify 111-Invalid card number status
Then assert Decline response with 20002 AuthDecline Code and Device is not delivered. as description
And user sign out from customer portal

Scenario:5 To Verify that the user can withdraw stoplist credit device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
And device has "normal" status
Then user sign out from customer portal

Scenario:6 Transaction - Verify that the transaction declines on the withdrawing the stoplisting of not activated card
Given user is logged in institution
When user raises an authorization request
And status of request is declined with reason Not delivered
And search Purchase authorization and verify 111-Invalid card number status
Then assert Decline response with 20002 AuthDecline Code and Device is not delivered. as description
And user sign out from customer portal
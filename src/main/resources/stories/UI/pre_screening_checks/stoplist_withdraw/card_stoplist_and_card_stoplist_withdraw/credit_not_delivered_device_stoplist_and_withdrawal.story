!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the users device can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_not_delivered_emv_retail_stoplist_withdraw
@CardStoplistAndWithdrawal
		 
Scenario:1 creation of mastercard_individual_primary_msr Card credit device
Given setting json values in excel for Credit
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:2 To Verify that the user can stoplist credit device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
And user edits deviceplan and enables stoplist flag
And device has "lost" status
Then user sign out from customer portal

Scenario:3 Transaction - Verify that the transaction declines with appropriate response for stoplisting
Given user is logged in institution
When user raises an authorization request
And status of request is declined with reason Lost
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
Then assert Capture response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
And user sign out from customer portal

Scenario:4 To Verify that the user can withdraw stoplist credit device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
And device has "normal" status
Then user sign out from customer portal

Scenario:4 Transaction - Verify that the user is able to make a successful transaction on the withdrawaing the stoplisting
Given user is logged in institution
When user raises an authorization request
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal


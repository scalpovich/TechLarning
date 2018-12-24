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

Scenario:3 To Verify that the user can stoplist device range of credit device
Given user is logged in institution
When user stoplists a device range from stoplist device range screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:4 Transaction - MSR_PREAUTH Authorization transaction on credit device after stoplisted device range
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And user is logged in institution
Then search Pre-Auth authorization and verify 207-PICK-UP CARD status
And assert Capture response with 27001 AuthDecline Code and Device range is stoplisted. as description
And user sign out from customer portal

Scenario:5 To Verify that the user can withdraw stoplist device range of credit device
Given user is logged in institution
When user withdraws a device range from withdraw device range screen
Then user sign out from customer portal

Scenario:6 Transaction - MSR_PREAUTH Authorization transaction on credit device after withdrawn device range
Given perform an MSR_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
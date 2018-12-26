!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device bin 
so that the user's device bin can be stoplisted and stoplist withdrawal

Meta:
@StoryName credit_emv_retail_stoplist_withdraw	
		 
Scenario:1 creation of mastercard_individual_primary_msr Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:2 To Verify that the user can stoplist device bin of credit device
Given user is logged in institution
When user stoplists a device bin from stoplist device bin screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:3 Transaction - MSR_PREAUTH Authorization transaction on credit device after stoplisted device bin
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And user is logged in institution
And search Pre-Auth authorization and verify 207-PICK-UP CARD status
And assert Capture response with 27002 AuthDecline Code and Bin is stoplisted. as description
Then user sign out from customer portal

Scenario:4 To Verify that the user can withdraw stoplist device bin of credit device
Given user is logged in institution
When user withdraws a device Bin from withdraw device Bin screen
Then user sign out from customer portal

Scenario:5 Transaction - MSR_PREAUTH Authorization transaction on credit device after withdrawn device bin
Given perform an MSR_PREAUTH MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
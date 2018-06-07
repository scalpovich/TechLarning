!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device  
so that the user's device can be stoplisted and stoplist withdrawal

Meta:
@CreditRegression
@StoryName credit_emv_retail_stoplist_withdraw				 
Scenario:creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
Then embossing file batch was generated in correct format
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal

Scenario:To Verify that the user can stoplist device from stoplist screen
Given user is logged in institution
When user stoplists a card from stoplist device screen
Then device has "lost" status
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device from stoplist screen
Given user is logged in institution
When user withdraws a card from withdraw device screen
Then device has "normal" status
Then user sign out from customer portal


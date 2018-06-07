!-- @author: E076170
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can validate credit transaction limit
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
And for Limited Validity Virtual Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Add-on Device fills New Program Retail Credit Card section for credit product for Mastercard
When for Add-on Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Bank Staff and Primary Device and New Client and Limited Validity Virtual Card
Then credit device is created using new device screen for Bank Staff and Add-on Device and New Client and Limited Validity Virtual Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then credit processes pinProduction batch using new Device
Then User search for new application on search screen for credit and validates the status as NORMAL
When user activates device through helpdesk

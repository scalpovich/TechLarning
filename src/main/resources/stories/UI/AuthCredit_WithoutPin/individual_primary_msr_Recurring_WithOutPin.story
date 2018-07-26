Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on retail credit card.
Meta:
@CreditRegression
@CreditWithOutPin
@StoryName credit_msr_retail				 
Scenario:creation of mastercard_individual_primary_msr Card credit device
Meta:
@TestId TC550110
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
Then credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And embossing file batch was generated in correct format

Scenario: Perform RECURRING_PUR_TXN Authorization transaction
Given connection to MAS is established
When perform an MSR_RECURRING_PUR_TXN MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
Given Auth file is generated after transaction
When MAS simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
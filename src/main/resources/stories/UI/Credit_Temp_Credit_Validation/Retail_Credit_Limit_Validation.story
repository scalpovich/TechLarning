
Narrative:
As a Customer portal user
I want to validate temproary credit limit for retail card
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can validate credit transaction limit for retail card
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
And for Magnetic Stripe Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
When user assigns service code to program
Then credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
Then credit processes pinProduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user activates credit limit change request
Then user verify available Card limit for card after transaction
And user sign out from customer portal


Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user verify available balance after transaction
Then device has "normal" status
Then user verify available Card limit for card after transaction
And user sign out from customer portal










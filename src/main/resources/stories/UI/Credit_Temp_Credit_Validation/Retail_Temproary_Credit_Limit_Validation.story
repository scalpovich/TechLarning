Narrative:
As a Customer portal user
I want to validate permanent credit limit for retail card
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can validate credit transaction limit for retail card
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
And for Magnetic Stripe Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And user assigns service code to program
Then user sign out from customer portal

Scenario:Card Production
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user activates permanent credit limit change request
And device has "normal" status
And user verify available Card limit for card after transaction
Then user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user verify temproary credit limit for credit product
Then user sign out from customer portal
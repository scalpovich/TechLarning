!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device range 
so that the user's device range can be stoplisted and stoplist withdrawal

Meta:
@CreditRegression
@StoryName credit_emv_retail_stoplist_withdraw			 
Scenario:creation of mastercard_individual_primary_msr Card credit device
Meta:
@TestId TC550110
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
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
When embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:To Verify that the user can stoplist device range of credit device
Given user is logged in institution
When user stoplists a device range from stoplist device range screen
When edit deviceplan and enable stoplist flag
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on credit device after stoplisted device range
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Given user is logged in institution
Then search Pre-Auth authorization and verify 207-PICK-UP CARD status
Then assert Capture response with 27001 AuthDecline Code and Device range is stoplisted. as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device range of credit device
Given user is logged in institution
When user withdraws a device range from withdraw device range screen
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on credit device after withdrawn device range
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction on the same card
Then MAS test results are verified
Then MAS simulator is closed
Given user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal

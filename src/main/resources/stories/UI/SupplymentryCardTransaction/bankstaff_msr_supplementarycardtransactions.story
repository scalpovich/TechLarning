Narrative:
In order to check credit supplementary device functionality
As a issuer 
I want to perform transaction on supplementary device

Meta:
@CreditSupplementaryCardTransaction
@StoryName credit_emv_retail
@SupplementaryCardTransaction			 

Scenario:creation of mastercard_bankstaff_supplementary_msr credit device

Given setting json values in excel for Credit
And user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And for Magnetic Stripe Card User fills Supplementary Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Supplementary Device fills Existing Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And for Supplementary Device and Existing Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit device is created using new device screen for Individual and Supplementary Device and Existing and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
When user selects secondary card for transaction
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File
And embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Transaction - MSR_PREAUTH and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
When user is logged in institution
Then search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
Given perform an MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
When user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Given perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
When user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Given perform an MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
When user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Given perform an MSR_CASH_WITHDRAWAL MAS transaction on the same card
Then MAS test results are verified
And MAS simulator is closed
When user is logged in institution
Then search CWD authorization and verify 000-Successful status
And user sign out from customer portal
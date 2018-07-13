Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_msr_retail
@DipeshSirExecution				 
Scenario:creation of mastercard_corporate_primary_msr Card credit device
Meta:
@TestId TC565834
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
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_REFUND Authorization transaction
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Refund authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario: Perform RECURRING_PUR_TXN Authorization transaction
When perform an MSR_RECURRING_PUR_TXN MAS transaction on the same card
Then MAS test results are verified
And Auth file is generated after transaction
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
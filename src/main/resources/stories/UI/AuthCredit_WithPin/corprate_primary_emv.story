Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_emv_retail
@DipeshSirExecution				 
Scenario:creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
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
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
When credit processes pingeneration batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: emv corporate credit card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"

Scenario: Perform EMV_REFUND Authorization transaction
Given connection to MAS is established
When perform an EMV_REFUND MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario: Perform RECURRING_PUR_TXN Authorization transaction
When perform an EMV_RECURRING_PUR_TXN MAS transaction on the same card
Then MAS test results are verified
When Auth file is generated after transaction
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: perform ECCOM-PURCHASE authorization on retail emv card
When perform an ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
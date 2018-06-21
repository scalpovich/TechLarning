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
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
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
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
When embossing file batch was generated in correct format


Scenario: Perform ASI_MSR Authorization transaction on Individual Primary MSR Card
Given connection to MAS is established
When perform an ASI_EMV MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal

Scenario: Perform ASI_PAYMENT_WITH_AMOUNT Authorization transaction
When perform an ASI_PAYMENT_WITH_AMOUNT MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal

Scenario: perform ECCOM-PURCHASE authorization on retail emv card
When perform an ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario: perform 3D_SECURE_CAVV authorization on corporate msr card
When perform an 3D_SECURE_CAVV MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_REFUND Authorization transaction
When perform an EMV_REFUND MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario: Perform RECURRING_PUR_TXN Authorization transaction
When perform an EMV_RECURRING_PUR_TXN MAS transaction on the same card
Then MAS test results are verified
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
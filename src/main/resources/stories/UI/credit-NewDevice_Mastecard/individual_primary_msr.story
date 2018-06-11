Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_msr_retail
@Individual
@Primary				 
Scenario:creation of mastercard_individual_primary_msr Card credit device
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
Then credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
Then credit processes pingeneration batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform ASI_MSR Authorization transaction on Individual Primary MSR Card
Given connection to MAS is established
When perform an ASI_MSR MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal

Scenario: Perform MMSR Authorization transaction on Individual Primary MSR Card
When perform an MMSR MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal
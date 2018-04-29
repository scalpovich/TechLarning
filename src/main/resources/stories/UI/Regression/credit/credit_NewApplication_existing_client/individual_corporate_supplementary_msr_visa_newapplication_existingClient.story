!-- author: e076177
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_msr_retail					 
Scenario: Uuser creates a Credit Device Using New Application screen with Existing client of msr type for visa
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
And for EMV Card User fills Device Plan for credit product for Visa
And for Magnetic Stripe Card User fills Supplementary Device Plan for credit product for Visa
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User fills Program Retail Credit Card section for credit product for Visa
When for Primary Device and New Client user fills Device Range section for credit product
When for Supplementary Device and Existing Client user fills Device Range section for credit product
Then credit device is created using new Application screen for Individual and Primary Device and New Client and EMV Card
Then credit device is created using new Application screen for Individual and Supplementary Device and Existing Client and Magnetic Stripe Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
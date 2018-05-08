Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_emv_corp				 
Scenario:creation of visa_corporate_primary_Physical NFC Device Paypass Card credit device
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
And for Physical NFC Device - Paypass User fills Device Plan for credit product for Visa
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Supplementary Device fills Existing Program Corporate Credit Card section for credit product for Visa
When for Add-on Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Add-on Device and New Client and Physical NFC Device - Paypass
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
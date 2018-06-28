Narrative:
In order to a create a Credit Device under customer portal with priority pass
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName CardBoarding_Priority				 
Scenario:creation of mastercard_individual_primary_emv Card credit device with priority pass through New Device
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
And for "EMV Card" User create Device Plan for "credit" product for "Mastercard" and "with" priority pass
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And fills Wallet Plan for credit product and program Retail Credit Card [9]
And User fills MCC Rules for credit product
And User Primary Device [P] fills New Client [N] Program Retail Credit Card [9] section for credit product for Mastercard
When User fills Device Range section for credit product
And user sign out from customer portal

Scenario:Create device through above created configuration
Given user is logged in institution
Then credit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and EMV Card [2]
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
And user sign out from customer portal
Narrative:
In order to a create a Credit Device under customer portal with priority pass
As a user
I want to assert pages

Meta:
@StoryName CardBoarding_Priority				 
Scenario:creation of mastercard_individual_primary_emv Card credit device with priority pass through New Device
Given setting json values in excel for Credit
When user is logged in institution
And User fills Dedupe Plan
And User fills Statement Message Plan for CREDIT product
And User fills Marketing Message Plan for CREDIT product
And User fills Transaction Plan for CREDIT product
And User fills Transaction Limit Plan for CREDIT product
And User fills Document Checklist Screen for CREDIT product
And User fills Device Joining and Membership Fee Plan for CREDIT product
And User fills Device Event Based Fee Plan for CREDIT product
And for "EMV Card" User fills Device Plan for "CREDIT" product for "Mastercard" and "with" priority pass
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for CREDIT product
And fills Wallet Plan for CREDIT product and program Retail Credit Card [9]
And User fills MCC Rules for CREDIT product
And User Primary Device [P] fills New Client [N] Program Retail Credit Card [9] section for CREDIT product for Mastercard
And User fills Device Range section for CREDIT product
And CREDIT device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and EMV Card [2]
And CREDIT processes pre-production batch using new Device
And CREDIT processes deviceproduction batch using new Device
Then User search for new device on search screen for CREDIT and validates the status as NORMAL
And user sign out from customer portal
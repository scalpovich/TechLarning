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
And User fills Statement Message Plan for Credit product
And User fills Marketing Message Plan for Credit product
And User fills Transaction Plan for Credit product
And User fills Transaction Limit Plan for Credit product
And User fills Document Checklist Screen for Credit product
And User fills Device Joining and Membership Fee Plan for Credit product
And User fills Device Event Based Fee Plan for Credit product
And for "EMV Card" User fills Device Plan for "Credit" product for "Mastercard" and "with" priority pass
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for Credit product
And fills Wallet Plan for Credit product and program Retail Credit Card [9]
And User fills MCC Rules for Credit product
And User Primary Device [P] fills New Client [N] Program Retail Credit Card [9] section for Credit product for Mastercard
And User fills Device Range section for Credit product
And Credit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and EMV Card [2]
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device
Then User search for new device on search screen for Credit and validates the status as NORMAL [0]
And user sign out from customer portal
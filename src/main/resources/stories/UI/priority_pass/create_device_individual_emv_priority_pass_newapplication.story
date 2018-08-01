Narrative:
In order to a create a Credit Device under customer portal with priority pass
As a user
I want to assert pages

Meta:
@StoryName CardBoarding_Priority				 
Scenario:creation of mastercard_individual_primary_emv Card credit device with priority pass through New Application
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
And for "EMV Card" User create Device Plan for "CREDIT" product for "Mastercard" and "with" priority pass
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for CREDIT product
And User fills Wallet Plan for CREDIT product and program Retail Credit Card [9]
And User fills MCC Rules for CREDIT product
And User Primary Device [P] fills New Client [N] Program Retail Credit Card [9] section for CREDIT product for Mastercard
And User fills Device Range section for CREDIT product
And "CREDIT" is created with "Primary Device [P]" as application type with application sub-type as "New Client [N]" and customer of type "Individual [0]" with "EMV Card [2]"
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And CREDIT processes pre-production batch using new Application
And CREDIT processes deviceproduction batch using new Application
And new Application processes pin generation batch for CREDIT
Then User search for new application on search screen for CREDIT and validates the status as NORMAL
And user sign out from customer portal
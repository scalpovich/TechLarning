!-- author: e076178
Narrative:
In order to a create a Credit device with loan 
As a user
I want to validate card boarding with Loan

Meta:
@StoryName loan_process
Scenario: User creates a Credit Device Using New Application screen with Existing client of emv type for mastercard interchance
Given setting json values in excel for Credit
When user is logged in institution
And User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And User fills Device Plan for credit product with MASTERCARD [02] and EMV Card [2]
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card [9]
And User fills MCC Rules for credit product
And User Primary fills new Program Retail Credit Card [9] section for credit product for MASTERCARD [02]
And User fills Device Range section for credit product
And user creates loan plan for credit
And "credit" is created with "Primary Device [P]" as application type with application sub-type as "New Client [N]" and customer of type "Bank Staff [2]" with "EMV Card [2]"
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL
And user sign out from customer portal
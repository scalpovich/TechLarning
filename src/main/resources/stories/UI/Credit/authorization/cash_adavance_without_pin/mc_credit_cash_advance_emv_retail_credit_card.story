Narrative:
In order to verify cash advance transaction for mastercard emv retail credit card
As a user
I want to able to perform and validate cash advance transaction

Meta:
@StoryName TC556760

Scenario: To verify cash advance transaction for MasterCard emv retail credit card
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
When User fills Device Plan for "credit" "emv" card with no pin
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
When fills Wallet Plan for credit product and program Retail Credit Card [9]
And User fills MCC Rules for credit product
When User fills Program section for credit product and program Retail Credit Card [9]
When User fills Device Range section for credit product
Then credit device is created using new device screen
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
When user performs adjustment transaction
Then user sign out from customer portal


Scenario:Connect to MAS Simulator and perform the transaction
Given connection to MAS is established
When user performs an EMV_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then MAS simulator is closed

Scenario: Generate Auth File for Clearing
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal
Narrative:
In order to verify purchase and purchase with cashback transaction for mastercard corporate msr credit card
As a user
I want to able to perform and validate the transaction

Meta:
@StoryName TC556866
@CreditPurchaseWithCashback

Scenario: To verify purchase and purchase with cashback transaction for MasterCard corporate msr credit card
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
When User fills Device Plan for "credit" "magnetic stripe" card with no pin
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
When fills Wallet Plan for credit product and program Corporate Credit Card [10]
And User fills MCC Rules for credit product
When User fills Program section for credit product and program Corporate Credit Card [10]
When User fills Device Range section for credit product
Then credit device is created using new device screen
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
When user performs adjustment transaction
Then user sign out from customer portal

Scenario:Connect to MAS Simulator and perform the EMV_PURCHASE transaction
Given connection to MAS is established
When user performs an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario:Verify the transaction on Authorization search on customer portal
Given user is logged in institution
Then search Purchase authorization and verify Successful status
And user sign out from customer portal


Scenario:Connect to MAS Simulator and perform the EMV_PURCHASE_WITH_CASHBACK transaction
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified

Scenario:Verify the transaction on Authorization search on customer portal
Given user is logged in institution
Then search Purchase with Cash back authorization and verify Successful status
When user sign out from customer portal
And MAS simulator is closed
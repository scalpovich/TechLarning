Narrative:
In order to check transactions on msr retail credit card 
As an issuer
I want to authorize REFUND transaction for msr retail credit card

Meta:
@StoryName TC556786

Scenario: To verify cash withdrawal transaction for MasterCard msr retail credit device
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
When fills Wallet Plan for credit product and program Retail Credit Card [9]
And User fills MCC Rules for credit product
When User fills Program section for credit product and program Retail Credit Card [9]
When User fills Device Range section for credit product
Then credit device is created using new device screen
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL

Scenario: setup currency for device
Given user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
And user sign out from customer portal

Scenario:Connect to MAS Simulator and perform the transaction
Given connection to MAS is established
When user performs an MSR_REFUND MAS transaction
Then MAS test results are verified

Scenario:Verify the transaction on Authorization search on customer portal
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal

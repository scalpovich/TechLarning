credit emv verification of joining and membership fee

Narrative:
In order to provide to client easy-to-use multi-purpose credit card pinless
As an issuer
I want to create EMV Credit card pinless and verify joining and membersip fee

Meta:
@StoryName credit_emv_retail_promotion

Scenario: Set up credit emv retail general purpose card device production
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And User fills Device Plan for "credit" "emv" card
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product
And User fills MCC Rules for credit product
And User fills Program section for credit product and program Retail Credit Card [9]	
When User fills Device Range section for credit product
Then credit device is created using new device screen with JMF Promotion [JMFPR1] plan
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then device has "normal" status
And user sign out from customer portal

Scenario: Joining and MemberShip Fees is been Deducted
Given user is logged in institution
Then search with device in transaction screen and status for Joining and Membership Fees
And user signs out from customer portal

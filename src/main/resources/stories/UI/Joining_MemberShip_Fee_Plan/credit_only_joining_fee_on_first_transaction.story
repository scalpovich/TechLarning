credit emv verification of joining and membership fee

Narrative:
In order to provide to client easy-to-use multi-purpose credit card pinless
As an issuer
I want to create EMV Credit card pinless and verify joining and membersip fee

Meta:
@StoryName credit_emv_retail_firsttransaction

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
Then credit device is created using new device screen
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then credit processes pinProduction batch using new Device
Then device has "normal" status
And user sign out from customer portal


Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Joining and MemberShip Fees is been Deducted
Given user is logged in institution
Then search with device in transaction screen and status for Joining and Membership Fees
And user signs out from customer portal

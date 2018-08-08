Narrative:
In order to test transaction with invalid pin and reset pin retry counter
As an issuer
I want to perform transactions for credit emv retail card

Meta:
@StoryName credit_emv_retail
@pinRetryLimitValidationAndResetCounter
	 
Scenario:creation of mastercard_bankstaff_primary_emv credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
And user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Bank Staff and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And embossing file batch was generated in correct format
And user sets invalid pin
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 117-Incorrect PIN status
And assert Decline response with 46051 AuthDecline Code and Incorrect Pin. as description
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction for pin retry limit check
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 106-Allowable Pin tries exceeded status
And assert Decline response with 46053 AuthDecline Code and Pin retry limit exceeded. as description
And device has "normal" status
And user raise service request for Reset Pin Retry Counter [109] service
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then PIN is retrieved successfully with data from Pin Offset File

Scenario: Perform EMV_PURCHASE Authorization transaction with valid pin
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And FINSim simulator is closed
And MAS simulator is closed
Narrative:
In order to test transaction plan without assigned transaction for credit emv retails card
As an issuer
I want to failed transactions for prepaid emv retail card

Meta:
@StoryName credit_emv_retail
@TransactionPlanWithAssignTransactions
				 
Scenario:creation of mastercard_bankstaff_primary_emv credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel
And user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User create empty Transaction Plan for credit product
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
When for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Bank Staff and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
When credit processes pingeneration batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File
And embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 119-Transaction not permitted status
And assert Decline response with 10001 AuthDecline Code and Transaction not permitted to device holder. as description
And user sign out from customer portal
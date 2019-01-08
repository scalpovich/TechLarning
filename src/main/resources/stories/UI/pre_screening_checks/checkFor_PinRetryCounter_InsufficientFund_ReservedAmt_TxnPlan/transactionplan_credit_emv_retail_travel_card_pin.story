Narrative:
In order to test transaction plan without assigned transaction for credit emv retails card
As an issuer
I want to fail transactions for credit emv retail card

Meta:
@StoryName credit_emv_retail
@TransactionPlanWithoutAssignTransactions
@TransactionPlanWithoutAssignTransactionsCredit
				 
Scenario:creation of mastercard_bankstaff_primary_emv credit device
Meta:
@UserCreatesNewCreditDevice
Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And User creates empty Transaction Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal


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
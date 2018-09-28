credit emv verification of joining fee

Narrative:
In order to provide to client easy-to-use multi-purpose credit card with pin
As an issuer
I want to create EMV Credit card with pin and verify joining Fee

Meta:
@StoryName credit_emv_retail_firsttransaction
@JMFCreditPlans

Scenario: Set up credit emv retail general purpose card device production
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Visa
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - Purchase with pin transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin_Highrisk VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin_Highrisk
And search Purchase authorization and verify Successful status
And user verifies available balance after transaction
And user sign out from customer portal
Then VISA simulator is closed

Scenario: Post maintenance batch and pre-clearing batch is run 
Given user is logged in institution
When post maintenence batch is run
And user processes Pre-clearing system internal batch for Credit
Then user sign out from customer portal

Scenario: Joining Fee is been Deducted
Given user is logged in institution
When search with device in transaction screen and status for Joining Fee
Then user signs out from customer portal


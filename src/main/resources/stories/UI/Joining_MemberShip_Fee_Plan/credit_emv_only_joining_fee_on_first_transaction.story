credit emv verification of joining fee

Narrative:
In order to provide to client easy-to-use retail general purpose credit card with pin
As an issuer
I want to create EMV Credit card with pin and verify joining Fee

Meta:
@StoryName credit_emv_retail_firsttransaction
@JMFCreditPlans

Scenario: 1.1 Set up credit emv retail general purpose card device production
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed

Scenario: 1.4 Post maintenance batch and pre-clearing batch is run 
Given user is logged in institution
When post maintenance batch is run
And user processes Pre-clearing system internal batch for Credit
And user sign out from customer portal

Scenario: 1.5 Joining Fee is been Deducted
Given user is logged in institution
When search with device in transaction screen and Verify Joining Fee
And user signs out from customer portal


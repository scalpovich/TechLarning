Narrative:
In order to verify the mcc overlimit functionality for credit products
As a user
I want to trigger a cash withdrawal transaction on a corporate credit card where mcc overlimit is set
So that mcc overlimit functionality is tested and transaction gets declined

Meta:
@CreditFR
@FR
@StoryName credit_emv_retail_overlimit
@mcc_overlimit 
@mcc_overlimit_tx_decline

Scenario:1 creation of corporate emv credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Overlimit details
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user sign out from customer portal

Scenario:2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:3 Perform EMV_CASH_WITHDRAWAL Authorization transaction
Given connection to MAS is established
When perform an EMV_CASH_WITHDRAWAL MAS transaction
And MAS simulator is closed
Then user is logged in institution
And search CWD authorization and verify 116-Insufficient Fund status
And user sign out from customer portal

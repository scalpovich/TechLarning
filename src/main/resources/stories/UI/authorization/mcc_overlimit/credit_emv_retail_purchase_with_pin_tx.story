Narrative:
In order to verify the mcc overlimit functionality for credit products
As a user
I want to trigger a purchase transaction on a credit card where mcc overlimit is set
So that mcc overlimit functionality is tested and transaction gets verified

Meta:
@CreditFR
@FR
@StoryName credit_emv_retail_overlimit
@mcc_overlimit 

Scenario:1 Creation of retail emv credit device
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Overlimit details
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And user signs out from customer portal

Scenario:2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:4 Perform EMV_CASH_WITHDRAWAL Authorization transaction
When perform an EMV_CASH_WITHDRAWAL MAS transaction on the same card
And MAS simulator is closed
And user is logged in institution
Then search CWD authorization and verify 116-Insufficient Fund status
And user sign out from customer portal

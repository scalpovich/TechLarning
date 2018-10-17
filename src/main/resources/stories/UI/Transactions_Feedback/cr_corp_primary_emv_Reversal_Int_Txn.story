Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card to assert Reversal for International Transaction.

Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail				 
Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And verify markup fee applied on transaction
And user verifies available balance after transaction
And user sign out from customer portal

Scenario:1.4 When user perform Reveral of Purchase Transaction
Given user is logged in institution
When user generates Reversal for Transaction
Then search Purchase Reversal authorization and verify 000-Successful status
And user verifies available balance after reversal
And MAS simulator is closed
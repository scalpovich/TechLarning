Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card.

Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail				 
Scenario:creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel for Credit
Given user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario: Verify User is able to make Payment of credit card through cash mode
Given user is logged in institution
And check card balance details through helpdesk
When user initiates cash payment
When user processes "Pre-clearing" system internal batch for Credit
When user processes "EOD-Credit" system internal batch for Credit
And recheck card balance details through helpdesk after payment
Then user check successful payments

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction with amount 750000
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
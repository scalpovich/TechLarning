Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card to assert Payment of Credit Card.

Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail				 
Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel for Credit
When user is logged in institution
And User fills Device Plan for "credit" "emv" card for issuer scripting
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal

Scenario:1.2 Verify User is able to make Payment of credit card through cash mode
Given user is logged in institution
When check card balance details through helpdesk
And user initiates cash payment
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And recheck card balance details through helpdesk after payment
Then user checks successful payments

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction with amount 800000
And user is logged in institution
And search Purchase authorization and verify 116-Insufficient Fund status
Then assert Decline response with 20005 AuthDecline Code and Account level - insufficient otbl. as description
And user sign out from customer portal
And MAS simulator is closed
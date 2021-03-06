Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert Pre-Screenning Checks by doing various transactions.

Meta:
@CreditRegression
@StoryName credit_emv_retail
@PreScreening
@TestId TC548377
	 
Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed
And User enters incorrect Expiry Date

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 101-EXPIRED CARD status
Then assert Decline response with 20005 AuthDecline Code and Device is expired. as description
And user sign out from customer portal
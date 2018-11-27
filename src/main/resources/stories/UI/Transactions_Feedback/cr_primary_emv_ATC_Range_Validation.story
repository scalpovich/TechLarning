Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card for ARQC Validation.

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
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed


Scenario:1.4 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0007

Scenario:1.5 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 100-Do Not Honour AuthDecline Code and ATC Range voilated. as description
And user sign out from customer portal
And MAS simulator is closed

Scenario:1.6 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0005

Scenario:1.7 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.8 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0000

Scenario:1.9 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 25004 AuthDecline Code and Duplicate ATC Received. as description
And user sign out from customer portal
And MAS simulator is closed
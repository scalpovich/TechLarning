Narrative:
In order to a validate Non Secure Transaction on credit device
As a user
I want to perform Purchase Transaction on corporate credit card to check Decline Non Secure Transaction
Meta:
@StoryName credit_emv_retail
@Abhishek_Credit

Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
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
And user edits All field of 3D Ecom Security for product Credit and interchange MasterCard as uncheck
Then user sign out from customer portal

Scenario:1.2 Check Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits Decline all non secured transaction field of 3D Ecom Security for product Credit and interchange MasterCard as check
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
And user is logged in institution
And search E-Commerce Transaction* authorization and verify 100-Do Not Honour status
And assert Decline response with 80019 AuthDecline Code and Non Secure Transaction as description
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.5 Uncheck Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits Decline all non secured transaction field of 3D Ecom Security for product Credit and interchange MasterCard as uncheck
Then user sign out from customer portal
Narrative:
In order to a validate 3 d secure Transaction on credit device
As a user
I want to perform 3 d secure Transaction without CVV2
Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail

Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel for Credit
When for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Corporate and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:1.2 Check Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline Merchant Risk Based Decisioning Transaction for product Credit and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
Given User set Decline Merchant Risk Based Decisioning Transaction flag true
When perform an 3D_SECURE_CAVV MAS transaction
And user is logged in institution
And search E-Commerce Transaction* authorization and verify 100-Do Not Honour status
And assert Decline response with 80040 AuthDecline Code and Merchant Risk Based Decisioning as description
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.5 Uncheck Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline Merchant Risk Based Decisioning Transaction for product Credit and interchange Mastercard as uncheck
Then user sign out from customer portal
Narrative:
In order to a validate Invalid CVV on credit device
As a user
I want to perform MSR_Purchase transaction to check MSR Transaction on EMV Card with Invalid CVV
Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail

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
Then user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And user sets invalid cvv/ccv2/icvv to device
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 183-CVV Verification Failure status
And assert Decline response with 46039 AuthDecline Code and Invalid CVV.. as description
And user sign out from customer portal
Then MAS simulator is closed
Narrative:
In order to verify 3D secure Scenarios on Credit EMV card
As an issuer
I want to authorize transactions for EMV Credit card

Meta:
@StoryName credit_emv_retail

Scenario:1 Set up Credit emv retail
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
And User search for new device on search screen for credit and validates the status as NORMAL
And user notes down available Card limit for card
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:2 Perform EMV-RetailGeneralPurposeCard E-COMM 3D SECURE 1st transaction
Given connection to MAS is established
When perform an 3D_SECURE_ECOMM_SCENARIO_1 MAS transaction
Then MAS test results are verified

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given perform an 3D_SECURE_ECOMM_SCENARIO_2 MAS transaction on the same card
Then MAS test results are verified
And MAS simulator is closed
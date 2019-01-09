Narrative:
In order to validate ATC
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail_Limits

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction 1 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user notes down ATC counter on device usage screen
Then user sign out from customer portal


Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction 2
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: 1.5 Perform EMV_PURCHASE Authorization transaction 3
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction 4
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
And user sign out from customer portal
Then MAS simulator is closed

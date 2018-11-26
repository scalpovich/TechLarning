Narrative:
In order to validate Reversal Funcationality
As an issuer
I want to perform reversal transaction

Meta:
@StoryName credit_emv_retail_Limits

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And user uses existing transaction limit plan for limit type TX_LIMIT_PLAN
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And user attachs device promotion plan PROMOTION_PLAN
And device has "normal" status
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV Cash Withdrawal
Given connection to MAS is established
Given user updates transaction amount to 100
And perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified
And user is logged in institution
And search CWD authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.4 Perform EMV Cash Withdrawal
Given user updates transaction amount to 10
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed
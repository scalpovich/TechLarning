Narrative:
In order to validate surcharge amount on transaction
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail_Limits
@Surchage

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

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
And user updates transaction amount to 80
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And Auth file is generated after transaction
And MAS simulator is closed

Scenario: 1.4 Authorization Search page validation
Given user is logged in institution
When search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
Then device has "normal" status
And user verifies available Card limit for card after transaction
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.5 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When user update surcharge amount 15 for transaction
And Auth file is generated
And Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
And MCPS simulator is closed

Scenario: 1.6 Upload ipm file from customer portal and process it
Given user is logged in institution
When User uploads the NOT file
And user processes batch for credit
Then user sign out from customer portal

Scenario: 1.7 Verify Surcharge before Matching Batch
Given user is logged in institution
When transaction status is "Matching Pending"
Then user validates surcharge amount for transaction

Scenario: 1.8 Verify Surcharge after Matching Batch
Given "Matching" batch for credit is successful
When transaction status is "Presentment Matched with authorization"
Then user validates surcharge amount for transaction
And user sign out from customer portal
Narrative:
In order to validate transaction status is updated to differenetial currency presentment 
As a Issuer
I want to perform transaction clearing with different settlement currency

Meta:
@StoryName credit_emv_retail_stoplist_withdraw
@ClearingNegativeScenario
 
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
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Generate Auth File for Clearing
Given Auth file is generated after transaction
When MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: 1.5 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And user update IPM file to get status Differential currency presentment
Then NOT file is successfully generated
And MCPS simulator is closed

Scenario: 1.6 Upload ipm file from customer portal and process it
Given user is logged in institution
When User uploads the NOT file
And user processes batch for credit
Then user sign out from customer portal

Scenario: 1.7 Matching & Posting to Cardholders account
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for credit is successful
And transaction status is "Differential currency presentment"
Then user sign out from customer portal
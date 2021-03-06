Narrative:
In order to check ageing functionality
As a user
I want to age the transaction by editing presentment time limit in device plan and verify the status in transaction details

Meta:
@CreditRegression
@StoryName credit_emv_retail_ageing
@Individual
@Primary	 

Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And user edits Presentment Time Limit in device plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:1.2 creation of mastercard_individual_primary_emv Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario: 1.2.1 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction and Generate Auth File for Clearing
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And Auth file is generated after transaction
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user verifies available balance after transaction
And verify fixed transaction fee applied on purchase transaction
And device has "normal" status
When user verifies available Card limit for card after transaction
Then user sign out from customer portal

Scenario:1.4 Login & Logout to wait for date to be updated 
Given update institution date to 4 days
When user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal

Scenario:1.5 Run Ageing Batch and verify reconciliation status
Given user is logged in institution
When "Ageing" batch for credit is successful
And user verifies reconciliation status Aged in auth search
Then user sign out from customer portal


Scenario:1.6 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And NOT file is successfully generated
Then MCPS simulator is closed

Scenario:1.7 Upload ipm file from customer portal and process it
Given user is logged in institution
When User uploads the NOT file
And user processes batch for credit
Then user sign out from customer portal

Scenario:1.8 Matching & Posting to Cardholders account
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for credit is successful
And transaction status is "Late presentment"
Then user sign out from customer portal
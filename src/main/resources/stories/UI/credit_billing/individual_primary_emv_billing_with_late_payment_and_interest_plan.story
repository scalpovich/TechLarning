Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to not payment for one bill cycle and verify late payment and interest is applied in in next billing

Meta:
@CreditRegression
@StoryName credit_emv_retail_billing
@Individual
@Primary	 

Scenario:1 creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And User fills Device Plan for "credit" "emv" card
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal

Scenario:2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario:4 Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:5 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And NOT file is successfully generated
When MCPS simulator is closed

Scenario:6 Upload ipm file from customer portal and process it
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
And user processes batch for credit
Then user sign out from customer portal

Scenario:7 Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And user processes Pre-clearing system internal batch for Credit
And "Matching" batch for credit is successful
And transaction status is "Presentment Matched with authorization"
When user processes EOD-Credit system internal batch for Credit
And user sign out from customer portal
And update institution date to first of next month

Scenario:8 Login & Logout to wait for date to be updated 
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:9 Process Batches
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user processes Billing Process - Credit system internal batch for Credit
And user verify Billed amount for Purchase category
And user run Statement Extract system internal batch
Then user sign out from customer portal


Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages and make full payment of bill

Meta:
@CreditRegression
@StoryName credit_emv_retail_billing
@Individual
@Primary	 

Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
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
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario:1.5 Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:1.6 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And NOT file is successfully generated
When MCPS simulator is closed

Scenario:1.7 Upload ipm file from customer portal and process it
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
And user processes batch for credit
Then user sign out from customer portal

Scenario:1.8 Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
When user processes Pre-clearing system internal batch for Credit
And "Matching" batch for credit is successful
And transaction status is "Presentment Matched with authorization"
When user processes EOD-Credit system internal batch for Credit
And user sign out from customer portal


Scenario:1.9 Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.0 Process Batches for billing and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user processes Billing Process - Credit system internal batch for Credit
And user verify Billed amount for Purchase category
And device has "normal" status
And user notes down required values from helpdesk for credit
And user run Statement Extract system internal batch
And verify statement file is successfully downloaded
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user sign out from customer portal

Scenario:2.1 Bump date 1 day ahead and Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to next day
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.2 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When check card balance details through helpdesk
And user initiates cash payment
And "Pre-clearing" batch for credit is successful
And "EOD-Credit" batch for credit is successful
And recheck card balance details through helpdesk after payment
Then user check successful after payment
When check card balance details through helpdesk
And user sign out from customer portal

Scenario:2.3 Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.4 Process Batches after paying full payment bill and verify payments
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And recheck card balance details through helpdesk after payment
Then user check successful after billing
When user run Statement Extract system internal batch
And verify statement file is successfully downloaded
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user sign out from customer portal
Narrative:
As a(n)  Customer portal user 
I want to configure the Loyalty Program
In order to manually reverse transaction
So that reversed accrued loyalty points can be verified for prepaid device
Meta:
@StoryName prepaid_emv_retail_loyalty
@migration_loyalty
		 
Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Given setting json values in excel for Prepaid
And user is logged in institution
When for EMV Card User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card
And User fills MCC Rules for prepaid product
And user selects all the transactions for loyalty transaction plan
And User Primary Device fills New Program Retail General Purpose Card section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
And prepaid processes pingeneration batch using new Device for Supplementary
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And device has "normal" status
Then user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario:1.4 Verify loyalty points when user perform Reversal of Purchase Transaction
Given user is logged in institution
Then user notes down max loyalty points for plan
And user notes down promotion plan details for AUTO
Then calculate loyalty points
When pre-clearing and Loyalty Calc batches are run
Then verify available loyalty points should be within loyalty plan limit
Then user add transaction reversal with reason Manual Reversal [1]
And pre-clearing and Loyalty Calc batches are run
And user verifies loyalty details for Prepaid device
And MAS simulator is closed


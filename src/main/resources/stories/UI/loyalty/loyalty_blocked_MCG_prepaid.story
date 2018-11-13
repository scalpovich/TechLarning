Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram with issuance and per transaction promotion plans
In order to verify accrued loyalty points on purchase transaction
Meta:
@StoryName prepaid_msr_retail_loyalty
@migration_loyalty

Scenario:1 Create credit device and perform manual auth on blocked MCC
Given setting json values in excel for Prepaid
Then use loyalty plan AUTOMATION [LP1]
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Prepaid product for Mastercard
And User fills Wallet Fee Plan for Prepaid product
And User fills Wallet Plan for Prepaid product and program Retail General Purpose Card
And user selects all the transactions for loyalty transaction plan
And User Primary Device fills New Program Retail General Purpose Card section for Prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for Prepaid [P] product
And Prepaid device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Prepaid processes pre-production batch using new Device
And Prepaid processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then add adjustment transaction of 10000 at backend
Then select blocked MCG for loyalty as MCG
Then user notes down max loyalty points for plan
And user notes down promotion plan details for PROMO2
And user has loyalty points details for Prepaid device
Then verify loyalty points are credited on issuance for promotion plan code PROMO1
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
And device has "normal" status
Then user waits for 5 minutes
And user sign out from customer portal

Scenario:2 Verify loyalty points should not be credited after manual auth
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
Then verify available loyalty points should be within loyalty plan limit
And user verifies loyalty details for Prepaid device
Then select blocked MCG for loyalty as -
And user sign out from customer portal
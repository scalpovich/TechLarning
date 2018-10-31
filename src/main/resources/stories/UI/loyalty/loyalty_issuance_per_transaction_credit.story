Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
In order to manually reverse transaction
So that reversed accrued loyalty points can be verified on credit device
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario:1 Loyalty points manual reversal - credit
Given setting json values in excel for Credit
Then use loyalty plan AUTOMATION [LP1]
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And user selects all the transactions for loyalty transaction plan
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user notes down max loyalty points for plan
!-- PROMO2 is per transaction promotion plan
And user notes down promotion plan details for PROMO2
And user has loyalty points details for Credit device
!-- PROMO1 is issuance promotion plan
Then verify loyalty points are credited on issuance for promotion plan code PROMO1
And verify available loyalty points should be within loyalty plan limit
And user raises an authorization request
Then calculate loyalty points
Then status of request is "approved"
And search Purchase authorization and verify Successful status
And device has "normal" status
Then user waits for 5 minutes
And user sign out from customer portal

Scenario:2 User verifies loyalty points after manual auth
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
Then verify available loyalty points should be within loyalty plan limit
And user verifies loyalty details for Credit device
And user sign out from customer portal

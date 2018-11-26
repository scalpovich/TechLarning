Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram with issuance and per transaction promotion plans
In order to verify accrued loyalty points on purchase transaction
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario:1 Create credit device
Given setting json values in excel for Credit
And use loyalty plan AUTOMATION [LP1]
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
Then select loyalty plan period unit as Month[M]/Year[Y] - Y
And user notes down max loyalty points for plan
And user notes down promotion plan details for PROMO2
And user has loyalty points details for Credit device
And verify loyalty points are credited on issuance for promotion plan code PROMO1
And select blocked MCG for loyalty as -
And user raises an authorization request
And calculate loyalty points
And status of request is "approved"
And search Purchase authorization and verify Successful status
And device has "normal" status
And user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario:2 Verify loyalty points after manual auth
Given user is logged in institution
When pre-clearing and Loyalty Calc batches are run
Then verify available loyalty points should be within loyalty plan limit
And user verifies loyalty details for Credit device
And user sign out from customer portal

Scenario:3 Verify loyalty points after manual reversal of transaction
Given user is logged in institution
When user add transaction reversal with reason Manual Reversal [1]
And pre-clearing and Loyalty Calc batches are run
Then user verifies loyalty details for Credit device
And user sign out from customer portal

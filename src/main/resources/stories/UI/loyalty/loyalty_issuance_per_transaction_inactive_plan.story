Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram with issuance and per transaction promotion plans
In order to verify points calculation for inactive loyalty plan
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario:1 create Credit device, deactivate loyalty plan and perform manual auth
Given setting json values in excel for Credit
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
Then user has loyalty points details for Credit device
And select loyalty plan period unit as Month[M]/Year[Y] - M
And deactivate loyalty plan
And user has loyalty points details for Credit device
And user raises an authorization request
And status of request is "approved"
And search Purchase authorization and verify Successful status
And device has "normal" status
And user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario:2 verify loyalty points are not accrued post transaction
Given user is logged in institution
When pre-clearing and Loyalty Calc batches are run
Then user verifies loyalty details for Credit device
And activate loyalty plan
And user sign out from customer portal

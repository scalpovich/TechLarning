Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram in device
In order to verify that loyalty points are not calculated when surcharge reversal is defined
Meta:
@StoryName credit_msr_retail_loyalty_surcharge
@migration_loyalty

Scenario: Create credit device in with surcharge and surcharge reversal plan attached and perform manual auth
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And User fills Transaction Plan for Credit product
And user selects all the transactions for loyalty transaction plan
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user notes down max loyalty points for plan
And user notes down promotion plan details for AUTO
And user has loyalty points details for Credit device
Then user raises an authorization request
And status of request is "approved"
And search Purchase authorization and verify Successful status
And user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario: 2 Verify loyalty points are not calculated
Given user is logged in institution
When pre-clearing and Loyalty Calc batches are run
Then user verifies loyalty details for Credit device
And user sign out from customer portal

Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
In order to perform manual auth and verify loyalty points in loyalty report
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario:1 Create credit device and perform manual auth
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
When User fills Transaction Plan for Credit product
And user selects all the transactions for loyalty transaction plan
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
When user notes down available Card limit for card
Then user notes down max loyalty points for plan
And user notes down promotion plan details for AUTO
Then user has loyalty points details for Credit device
And user raises an authorization request
And status of request is "approved"
Then calculate loyalty points
And search Purchase authorization and verify Successful status
Then user waits for 5 minutes
And user sign out from customer portal

Scenario:2 Validate loyalty points in loyalty report
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
Then verify available loyalty points should be within loyalty plan limit
And verify loyalty points in loyalty report against AUTO-Automation Test for Credit device
And user sign out from customer portal
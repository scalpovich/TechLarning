Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
In order to verify loyalty points when loyalty plan is not attached
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario:1 create Credit device without loyalty plan and perform manual auth
Given setting json values in excel for Credit
Then use loyalty plan none
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user has loyalty points details for Credit device
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
When user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
Then user waits for 5 minutes
And user sign out from customer portal

Scenario:2 verify loyalty points are not accrued post transaction
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
Then user verifies loyalty details for Credit device
And user sign out from customer portal



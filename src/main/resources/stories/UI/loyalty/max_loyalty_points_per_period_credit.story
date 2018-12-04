Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the max Loyalty points accrued is within loyalty plan limit per period - yearly
Meta:
@StoryName credit_msr_retail_loyalty
@loyalty	 

Scenario:1 Loyalty points - max accrued per period
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
And user notes down available Card limit for card
Then user raises an authorization request
And status of request is "approved"
And search Purchase authorization and verify Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario:2 verify max accrued loyalty points are within plan limit per period
Given user is logged in institution
When pre-clearing and Loyalty Calc batches are run
And user has loyalty points details for Credit device
Then verify available loyalty points should be within loyalty plan limit
And user sign out from customer portal

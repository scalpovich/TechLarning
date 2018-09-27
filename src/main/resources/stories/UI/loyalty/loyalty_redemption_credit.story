Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user
Meta:
@StoryName credit_msr_retail		 

Scenario: Loyalty points redemption - credit
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
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
When user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And pre-clearing and Loyalty Calc batches are run
And user verifies rewards and redemption screen
And user verifies current wallet balance amount information after loyalty redemption CREDIT device
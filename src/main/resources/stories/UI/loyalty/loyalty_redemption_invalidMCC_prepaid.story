Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user
Meta:
@StoryName credit_msr_retail_invalidMCC		 

Scenario: Loyalty points redemption - prepaid -invalidMCC
Given setting json values in excel for Prepaid
When user is logged in institution
And user selects all the transactions for loyalty transaction plan
And for Magnetic Stripe Card [1] User fills Device Plan for Prepaid product for Mastercard
And User fills Wallet Fee Plan for Prepaid product
And User fills Wallet Plan for Prepaid product and program Retail General Purpose Card
And User Primary Device fills New Program Retail General Purpose Card section for Prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for Prepaid [P] product
And Prepaid device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Prepaid processes pre-production batch using new Device
And Prepaid processes deviceproduction batch using new Device for Supplementary
And user sign out from customer portal

Scenario: Loyalty points redemption - prepaid -invalidMCC
Given setting json values in excel for Prepaid
When user is logged in institution
And user performs adjustment transaction
When user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
And user has current wallet balance amount information for Prepaid [P] device
And user sign out from customer portal

Scenario: Loyalty points redemption - prepaid -invalidMCC
Given setting json values in excel for Prepaid
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
And user verifies loyalty points not available for redemption
And user sign out from customer portal
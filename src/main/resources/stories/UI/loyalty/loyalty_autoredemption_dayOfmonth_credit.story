Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user

Meta:
@StoryName credit_msr_retail_loyalty		 


Scenario: 1.1- Loyalty program setup - credit
Given setting json values in excel for Credit
When user is logged in institution
And user selects all the transactions for loyalty transaction plan
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And user edits the loyalty plan AUTOMATION [AUTOREDEM1] for AutoRedemption day
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user notes down available Card limit for card
And user sign out from customer portal

Scenario: 1.2- Loyalty program setup - credit
Given setting json values in excel for Credit
When user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
When user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
Then user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario: 1.3- Loyalty program setup - credit
Given setting json values in excel for Credit
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
Then user verifies loyalty details for Credit device
And user sign out from customer portal
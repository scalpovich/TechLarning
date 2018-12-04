Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user

Meta:
@StoryName prepaid_msr_retail_loyalty	

Scenario: 1.1-Loyalty program setup - prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And user selects all the transactions for loyalty transaction plan
And for Magnetic Stripe Card [1] User fills Device Plan for Prepaid product for Mastercard
And User fills Wallet Fee Plan for Prepaid product
And User fills Wallet Plan for Prepaid product and program Retail General Purpose Card
And user adds promotion Plan with MCG
And user edits the start date for promotion plan
And user maps promotion Plan with loyalty Plan with priority 1
And User Primary Device fills New Program Retail General Purpose Card section for Prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for Prepaid [P] product
And Prepaid device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Prepaid processes pre-production batch using new Device
And Prepaid processes deviceproduction batch using new Device for Supplementary
Then user sign out from customer portal

Scenario: 1.2-Loyalty program setup - prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And user performs adjustment transaction
When user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify Successful status
And user has current wallet balance amount information for Prepaid [P] device
And user wait for 5 min to perform certain activity
And user sign out from customer portal

Scenario: 1.3-Loyalty program setup - prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And pre-clearing and Loyalty Calc batches are run
And user verifies rewards and redemption screen
And user verifies current wallet balance amount information after loyalty redemption PREPAID device
And user deletes promotion Plan and loyalty Plan mapping
Then user sign out from customer portal

Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user

Meta:
@StoryName prepaid_msr_retail_loyalty_cumulative		 

Scenario: Loyalty program setup - prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And user verifies current wallet balance amount information after loyalty redemption PREPAID device
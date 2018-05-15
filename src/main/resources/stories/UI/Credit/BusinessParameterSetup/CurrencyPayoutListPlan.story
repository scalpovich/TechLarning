Narrative:
In order to achieve something
As a user
I want to create surcharge plan
So that initial data setup is ready

Meta:
@CreditRegression
@CurrencyPayoutListPlan
@StoryName CurrencyPayoutList_Plan

Scenario: Scenario1 - Defining Currency Payout list Plan

Given user is logged in institution
When user creates currency payout list plan with details
Then currency payout list plan should get created successfully

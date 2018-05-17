Narrative:
In order to achieve something
As a user
I want to create surcharge plan
So that initial data setup is ready

Meta:
@CreditRegression
@MCGLimitPlan
@Author Nitin Kumar
@StoryName Surcharge_Plan

Scenario: Scenario1 - Defining MCG Limit Plan

Given user is logged in institution
When user creates MCG limit plan with details for Prepaid
Then MCG limit plan should get created successfully

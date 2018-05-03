Narrative:
In order to achieve something
As a user
I want to create surcharge plan
So that initial data setup is ready

Meta:
@CreditRegression
@SurchargePlan
@Author Saikat Sengupta
@StoryName Surcharge_Plan

Scenario: Scenario1 - Defining Surcharge Plan

Given user is logged in institution
!-- When user creates surcharge plan with details
!-- When user creates new business calendar
When user fills Merchant Category Group
Then surcharge plan should get created successfully

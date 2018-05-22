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
When Device Usage
!-- When user creates MCG limit plan with details for Prepaid
!-- Then MCG limit plan should get created successfully

Scenario: Set up corporate general purpose msr prepaid card
Meta:
@TestId TC407061
Given user is logged in institution
When user creates MCG limit plan with details for Prepaid
Given device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: corporate general purpose msr prepaid card device production
Meta:
@TestId TC408234
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk
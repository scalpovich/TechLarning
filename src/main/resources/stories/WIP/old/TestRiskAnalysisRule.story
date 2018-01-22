!-- author: e076177
Narrative:
In order to add and verify Risk Analysis Rule Plan under customer portal cardmanagement tab
As a user
I want to assert pages
Meta:
@CreditRegression
@StoryName CreditScenarios
Scenario:1 UI verification - Customer Portal - Valid Risk Analysis Rule Plan, card management tab
@ValidScenario
Given user is logged in institution
When User adds a Risk Analysis Rule Plan by entering valid values
Then user searches the record added based on filter Values
And user verifies delete operation


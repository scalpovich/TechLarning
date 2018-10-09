Narrative:
In order to validate transaction limit plan funcationality
As an issuer
I want to Create Transaction Limit Plan

Meta:
@StoryName credit_emv_retail_Limits
@CreateTxLimitPlan

Scenario: Create Domestic Transaction Limit Plan
Given user is logged in institution
When user creates transaction limit plan for prodcut debit and limit type daily
Then user signs out from customer portal
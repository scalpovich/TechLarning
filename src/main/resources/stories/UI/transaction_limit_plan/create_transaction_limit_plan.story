Narrative:
In order to validate transaction limit plan funcationality
As an issuer
I want to Create Transaction Limit Plan

Meta:
@StoryName credit_emv_retail_Limits
@CreateTxPlan

Scenario: 1.1 Create Domestic Transaction Limit Plan
Given user is logged in institution
When user creates transaction limit plan for prodcut prepaid and limit type Yearly
Then user signs out from customer portal
!-- author: e076177
Narrative:
In order to add and Verify CreditPlan under customer portal cardmanagement tab
As a user
I want to assert pages

@Meta:
CreditRegression					 
Scenario: UI verification - Customer Portal - User is able to add a Valid Credit Plan
Meta:
@UserAddsAValidCreditPlan
@TCName TC554188
@sheetName CreditScenarios
Given login to portal as existing bank as a user
When user navigates to Credit Plan Page and add a creditPlan

Scenario:UI verification - Cstomer Portal  - User is able to edit and verify a Valid Credit Plan
Meta:
@UserEditsAndVerifiesACreditPlan
@TCName TC554188
@sheetName CreditScenarios
Given login to portal as existing bank as a user
When user verifies edit and verify creditPlan



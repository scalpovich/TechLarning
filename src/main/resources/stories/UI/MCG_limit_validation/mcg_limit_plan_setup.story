Narrative:
In order to setup MCG limit plan
As an issuer
I want to create MCG Limit Plan for all product types

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_debit_emv_general_purpose

Scenario:1.1 Create MCG Limit Plan for Prepaid
Given user is logged in institution
And user creates MCG with MCC
And user creates MCG limit plan with details for Prepaid
Then MCG limit plan should get created successfully

Scenario:1.2 Create MCG Limit Plan for Credit
Given user is logged in institution
And user creates MCG with MCC
And user creates MCG limit plan with details for Credit
Then MCG limit plan should get created successfully

Scenario:1.3 Create MCG Limit Plan for Debit
Given user is logged in institution
And user creates MCG with MCC
And user creates MCG limit plan with details for Debit
Then MCG limit plan should get created successfully

Narrative:
In order to achieve something
As a user
I want to create surcharge plan
So that initial data setup is ready

Meta:
@CreditRegression
@SurchargePlan

Scenario: Scenario1 - Defining Surcharge Plan
Meta:
@sheetName Surcharge_Plan
@testDataFileName testdata
@TC554186_Define_Surcharge_Plan
@TCName TC554186_Define_Surcharge_Plan

Given login to portal as existing bank as a Customerusercred
When user creates surcharge plan with details
Then surcharge plan should get created successfully

Scenario: Scenario2 - Mandatory fields validation while adding surcharge plan
Meta:
@TC554186_Mandatory_Field_Validation

Given login to portal as existing bank as a Customerusercred
When user does not fill mandatory fields for SurchargePlan
Then appropriate validation should be triggered


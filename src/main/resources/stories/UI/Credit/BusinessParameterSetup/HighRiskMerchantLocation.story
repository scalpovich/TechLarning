Narrative:
In order to achieve something
As a user
I want to create High Risk Merchant Location
So that initial data setup is ready

Meta:
@CreditRegression
@HighRiskMerchantLocation
@Author Nitin Kumar

Scenario: Scenario1 - Defining High Risk Merchant Location

Given user is logged in institution
When user creates High Risk Merchant Location with details
Then High Risk Merchant Location should get created successfully

Scenario: Scenario2 - Mandatory fields validation while adding High Risk Merchant Location

Given user is logged in institution
When user does not fill mandatory fields in High Risk Merchant Location
Then appropriate validation should be triggered in High Risk Merchant Location


Narrative:
In order to achieve something
As a user
I want to create High Risk Merchant Location
So that initial data setup is ready

Meta:
@CreditRegression
@GatewayConfiguration
@Author Nitin Kumar
@StoryName GatewayConfig
Scenario: Defining Gateway Configurtaion

Given user is logged in institution
When user creates gateway configuration with details
Then gateway configuration should get created successfully

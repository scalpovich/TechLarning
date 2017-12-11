Narrative:
In order to setup business parameters
As a user
I want to create wallet plan
So that initial data setup is ready

Meta:
@CreditRegression
@WalletPlan
@Author Saikat Sengupta

Scenario: Scenario1 - Defining Surcharge Plan
Meta:
@sheetName Wallet_Plan
@testDataFileName testdata
@TC542586_Define_Wallet_Plan
@TCName TC542586_Define_Wallet_Plan

Given login to portal as existing bank as a Customeruser
When user creates Wallet Plan for Retail Credit Card
Then wallet plan should get created successfully

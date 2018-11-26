Narrative:
In order to a create a Payment Upload CSV from the set of input parameters(Device Creation)
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_emv_retail				 
Scenario:Payment Upload Csv creation based on input parameters
Meta:
@UserCreatesNewCreditDevice

Given setting json values in excel for Credit
And paymentUpload for Outstation_Cheque|Cash_Payment|Outstation_Cheque_return
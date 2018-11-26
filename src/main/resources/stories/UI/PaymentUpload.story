Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_emv_retail				 
Scenario:creation of mastercard_bankstaff_addon_primary_emv credit device
Meta:
@UserCreatesNewCreditDevice

Given setting json values in excel for Credit
And paymentUpload for Outstation_Cheque|Cash_Payment|Outstation_Cheque_return
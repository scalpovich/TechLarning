Narrative:
In order to a create a Payment Upload CSV from the set of input parameters
As a user
I want to onboard credit emv retail general purpose card and do payments with Payment Upload Batch

Meta:
@StoryName credit_emv_retail

Scenario: 1.1 Set up credit emv retail general purpose card device production
Given setting json values in excel for Credit
When user is logged in institution
And create Payment Upload CSV for Outstation_Cheque|Cash_Payment|DD_Payment|Local_Cheque and upload it on server
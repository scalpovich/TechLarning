Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV prepaid card

Meta:
@HighRiskTransaction
@Author Nitin Kumar
@StoryName HighRiskTransaction

Scenario: Set up prepaid emv retail general purpose card with MCG Limit Plan
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then validate auth report
Then validate the report
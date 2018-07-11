Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV prepaid card

Meta:
@HighRiskTransaction
@Author Nitin Kumar

Scenario: Set up prepaid emv retail general purpose card with MCG Limit Plan
Given user is logged in institution
Then validate the authCode in RAMP report
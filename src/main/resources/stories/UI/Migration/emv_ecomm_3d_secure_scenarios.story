Narrative:
In order to check mcg limit plan on Credit EMV card
As an issuer
I want to authorize transactions for EMV Credit card

Meta:
@StoryName credit_emv_retail

Scenario:2 Perform EMV-RetailGeneralPurposeCard E-COMM 3D SECURE 1st transaction
Given connection to MAS is established
When perform an 3D_SECURE_ECOMM_SCENARIO_1 MAS transaction
Then MAS test results are verified

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given perform an 3D_SECURE_ECOMM_SCENARIO_2 MAS transaction on the same card
Then MAS test results are verified
And MAS simulator is closed
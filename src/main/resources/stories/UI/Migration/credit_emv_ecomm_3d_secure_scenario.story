Narrative:
In order to check mcg limit plan on Credit EMV card
As an issuer
I want to authorize transactions for EMV Credit card

Meta:
@StoryName credit_emv_retail

Scenario:2 Perform EMV-RetailGeneralPurposeCard E-COMM 3D SECURE 1st transaction
Given connection to MAS is established
When perform an 3D_SECURE_SCENARIO_1 MAS transaction
Then MAS test results are verified
And user is logged in institution
And search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given perform an 3D_SECURE_SCENARIO_2 MAS transaction on the same card
Then MAS test results are verified
Then MAS simulator is closed
And user is logged in institution
And search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal
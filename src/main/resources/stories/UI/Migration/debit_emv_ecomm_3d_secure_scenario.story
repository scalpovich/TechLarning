Narrative:
In order to check mcg limit plan on Credit EMV card
As an issuer
I want to authorize transactions for EMV Credit card

Meta:
@StoryName d_emv_retail

Scenario:1 Set up prepaid emv retail general purpose card with MCG Limit Plan
Given setting json values in excel for Debit
And user is logged in institution
When User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for Debit product
And User fills Program section for Debit product
And User fills Business Mandatory Fields Screen for Debit product
And User fills Device Range section for Debit product
And user assigns service code to program
And user sign out from customer portal

Scenario:2 prepaid EMV retail general purpose card device production
Given user is logged in institution
When user creates new device of Debit type for new client
And a new device was created
And processes pre-production batch for Debit
And processes device production batch for Debit
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for Debit device
And user performs adjustment transaction
And user has current wallet balance amount information for Debit device
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:3 Perform EMV-RetailGeneralPurposeCard E-COMM 3D SECURE 1st transaction
Given connection to MAS is established
When perform an 3D_SECURE_SCENARIO_1 MAS transaction
Then MAS test results are verified
And user is logged in institution
And search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:4 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given perform an 3D_SECURE_SCENARIO_2 MAS transaction on the same card
Then MAS test results are verified
Then MAS simulator is closed
And user is logged in institution
And search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal
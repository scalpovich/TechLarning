Narrative:
In order to check mcg limit plan on Debit EMV card
As an issuer
I want to authorize transactions for EMV Debit card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_debit_emv_general_purpose

Scenario: Set up prepaid emv retail general purpose card with MCG Limit Plan
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client

Scenario: prepaid EMV retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
And processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify the MCG daily transaction in Device Usage Screen for domestic transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 40005 AuthDecline Code and Exceeds Amount Limit Domestic as description
And user sign out from customer portal


Narrative:
In order to check mcg limit plan on prepaid emv card
As an issuer
I want to authorize transactions for EMV prepaid card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_prepaid_emv_general_purpose

Scenario: Set up prepaid emv retail general purpose card with MCG Limit Plan
Given setting json values in excel for Prepaid
And user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid EMV retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify the MCG daily velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify the MCG daily velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 3rd transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify the MCG daily velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 4th transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And assert Decline response with 40008 AuthDecline Code and Frequency Exceeded International as description
And user sign out from customer portal


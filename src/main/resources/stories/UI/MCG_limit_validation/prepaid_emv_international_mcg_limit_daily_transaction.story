Narrative:
In order to check mcg limit plan on prepaid emv card
As an issuer
I want to authorize transactions for EMV prepaid card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_prepaid_emv_general_purpose

Scenario: Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 40005 AuthDecline Code and Exceeds Amount Limit International as description
And user sign out from customer portal


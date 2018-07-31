Narrative:
In order to check mcg limit plan on Debit EMV card
As an issuer
I want to authorize transactions for EMV Debit card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_debit_emv_general_purpose

Scenario: Set up program for debit MSR corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device

Scenario: debit msr corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily velocity in Device Usage Screen for domestic transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily velocity in Device Usage Screen for domestic transactions
And user sign out from customer portal

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 3rd transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And assert Decline response with 40008 AuthDecline Code and Frequency Exceeded Domestic as description
And user sign out from customer portal


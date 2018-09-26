Narrative:
In order to assert mcg limit plan on prepaid emv card for 
Per Transaction Limit, 
Periodic Transaction Amount 
and Periodic Transaction Velocity
As an issuer
I want to authorize transactions for EMV prepaid card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_periodic_prepaid_emv

Scenario:1 Set up prepaid emv retail general purpose card with MCG Limit Plan
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "Prepaid" "emv" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user sign out from customer portal

Scenario:2 prepaid EMV retail general purpose card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
And set the transaction amount to 110 in program currency
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 40002 AuthDecline Code and Exceeds Amount Limit Per Trans Domestic as description
Then verify the MCG limit utilization in Device Usage Screen for domestic transaction after failed transaction
And user sign out from customer portal

Scenario:4 Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
Given set the transaction amount to 90 in program currency
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for domestic transactions
And user sign out from customer portal

Scenario:5 Perform EMV-RetailGeneralPurposeCard Purchase 3rd transaction
Given set the transaction amount to 70 in program currency
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 40005 AuthDecline Code and Exceeds Amount Limit Domestic as description
Then verify the MCG limit utilization in Device Usage Screen for domestic transaction after failed transaction
And user sign out from customer portal

Scenario:6 Perform EMV-RetailGeneralPurposeCard Purchase 4th transaction
Given set the transaction amount to 20 in program currency
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for domestic transactions
And user sign out from customer portal

Scenario:7 Perform EMV-RetailGeneralPurposeCard Purchase 5th transaction
Given set the transaction amount to 20 in program currency
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And assert Decline response with 40005 AuthDecline Code and Exceeds Amount Limit Domestic as description
And verify the MCG limit utilization in Device Usage Screen for domestic transaction after failed transaction
And user sign out from customer portal


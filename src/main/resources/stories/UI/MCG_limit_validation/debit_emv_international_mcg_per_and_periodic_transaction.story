Narrative:
In order to check mcg limit plan on Debit emv card
As an issuer
I want to authorize transactions for EMV Debit card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_periodic_debit_emv_general_purpose

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

Scenario:2 Debit EMV retail general purpose card device production
Given user is logged in institution
When user creates new device of Debit type for new client
And a new device was created
And processes pre-production batch for Debit
And processes device production batch for Debit
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And fetches currency exchange rate from USD currency to program currency
And user has wallet number information for Debit device
And user performs adjustment transaction
And user has current wallet balance amount information for Debit device
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
And set the transaction amount to 110 in program currency
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 42002 AuthDecline Code and Exceeds Amount Limit Per Trans International as description
Then verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

Scenario:4 Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
Given set the transaction amount to 90 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario:5 Perform EMV-RetailGeneralPurposeCard Purchase 3rd transaction
Given set the transaction amount to 70 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 42011 AuthDecline Code and Exceeds Amount Limit Periodic International as description
Then verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

Scenario:6 Perform EMV-RetailGeneralPurposeCard Purchase 4th transaction
Given set the transaction amount to 20 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario:7 Perform EMV-RetailGeneralPurposeCard Purchase 5th transaction
Given set the transaction amount to 20 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And assert Decline response with 42014 AuthDecline Code and Frequency Exceeded Periodic International as description
And verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

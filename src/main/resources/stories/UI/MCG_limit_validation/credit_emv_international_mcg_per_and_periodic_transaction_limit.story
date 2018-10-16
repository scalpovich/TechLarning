Narrative:
In order to check mcg limit plan on Credit EMV card
As an issuer
I want to authorize transactions for EMV Credit card

Meta:
@MCGLimitPlan
@Author Nitin Kumar
@StoryName mcg_periodic_credit_emv_retail

Scenario:1 Set up Credit emv retail with MCG Limit Plan
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
And User search for new device on search screen for credit and validates the status as NORMAL
And fetches currency exchange rate from USD currency to program currency
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:2 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
And set the transaction amount to 110 in program currency
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 42005 AuthDecline Code and Exceeds Amount Limit Per Trans International as description
Then verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 2nd transaction
Given set the transaction amount to 90 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario:4 Perform EMV-RetailGeneralPurposeCard Purchase 3rd transaction
Given set the transaction amount to 70 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert Decline response with 42011 AuthDecline Code and Exceeds Amount Limit Periodic International as description
Then verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

Scenario:5 Perform EMV-RetailGeneralPurposeCard Purchase 4th transaction
Given set the transaction amount to 20 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify the MCG daily transaction and velocity in Device Usage Screen for international transactions
And user sign out from customer portal

Scenario:6 Perform EMV-RetailGeneralPurposeCard Purchase 5th transaction
Given set the transaction amount to 20 in program currency
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And assert Decline response with 42014 AuthDecline Code and Frequency Exceeded Periodic International as description
And verify the MCG limit utilization in Device Usage Screen for international transaction after failed transaction
And user sign out from customer portal

Narrative:
In order to validate Device Promotion Plan Priority
As an issuer
I want to perform transaction

Meta:
@StoryName d_emv_corp

Scenario: 1.1 Set up program for debit EMV corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: 1.2 debit EMV corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
And user attachs device promotion plan RATE_TX_FEE_PROMOTION_PLAN
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction to check transaction fee applied
Given connection to MAS is established
When user updates transaction amount to 70
And perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies VARIABLE_FEE applied on transaction
And user sign out from customer portal

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction to check minimum transaction fee applied
Given user updates transaction amount to 40
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies VARIABLE_FEE applied on transaction
And user sign out from customer portal

Scenario: 1.5 Perform EMV_PURCHASE Authorization transaction to check maximum transaction fee applied
Given user updates transaction amount to 110
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies VARIABLE_FEE applied on transaction
And user sign out from customer portal
And MAS simulator is closed
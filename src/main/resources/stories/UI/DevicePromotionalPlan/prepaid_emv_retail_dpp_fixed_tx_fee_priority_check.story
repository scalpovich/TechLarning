Narrative:
In order to validate Device Promotion Plan Priority
As an issuer
I want to perform transaction

Meta:
@StoryName prepaid_emv_retail_Limits
@DPPPrepaid

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user attaches device promotion plan FIXED_TX_FEE_PROMOTION_PLAN
And device has "normal" status
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction to check fixed fee applied
Given connection to MAS is established
When user updates transaction amount to 10
And perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies FIXED_FEE applied on transaction
And user sign out from customer portal

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction to check fixed fee applied
Given user updates transaction amount to 100
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies FIXED_FEE applied on transaction
And user sign out from customer portal

Scenario: 1.5 Perform EMV_PURCHASE Authorization transaction to check fixed fee applied
Given user updates transaction amount to 1000
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies FIXED_FEE applied on transaction
And user sign out from customer portal
And MAS simulator is closed
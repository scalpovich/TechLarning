prepaid msr retail general purpose card authorization

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose
@RecurringWithPin

Scenario: 1.0 Set up prepaid msr Retail general purpose card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "MAGNETIC STRIPE CARD" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: 1.1 prepaid msr retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
Then user sign out from customer portal

Scenario: 1.2 Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform MSR_RECURRING_PUR_TXN Authorization transaction
Given connection to MAS is established
When perform an MSR_RECURRING_PUR_TXN MAS transaction
Then MAS test results are verified

Scenario: 1.4 Generate Auth File for Clearing
Meta:
@TestId 
Given Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.5 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
And MCPS simulator is closed

Scenario: 1.6 Upload ipm file from customer portal and process it 
Given user is logged in institution
When User uploads the NOT file
And user processes batch for prepaid
Then user sign out from customer portal

Scenario: 1.7 Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
And user sign out from customer portal
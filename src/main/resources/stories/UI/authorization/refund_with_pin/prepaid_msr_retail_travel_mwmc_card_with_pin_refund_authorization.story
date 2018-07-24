Prepaid msr retail travel card multi currency refund with pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mwmc
@CRCardsWithAuthorizationRefundWithClearing

Scenario: Setup multi-currency prepaid msr retail travel card and perfomr refund with pin authorization
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Pin Production
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_REFUND Authorization transaction
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then MAS test results are verified


Scenario: Generate Auth File for Clearing
Meta:
@TestId 
Given Auth file is generated after transaction
When MAS simulator is closed
And user is logged in institution
And search Refund authorization and verify 000-Successful status
And verify transaction currency as INR [356] and billing currency as USD [840] on auth search
Then user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And NOT file is successfully generated
Then MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId 
Given user is logged in institution
When User uploads the NOT file
And user processes batch for prepaid
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for prepaid is successful
And transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal
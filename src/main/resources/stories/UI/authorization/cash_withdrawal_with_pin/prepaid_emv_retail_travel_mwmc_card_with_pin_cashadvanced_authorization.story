Prepaid emv retail travel card multi currency with pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_emv_retail_travel_mc

Scenario: Setup multi-currency prepaid emv retail travel card and perfomr cash advanced  without pin authorization
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user sign out from customer portal
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
And user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search CWD authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId 
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal

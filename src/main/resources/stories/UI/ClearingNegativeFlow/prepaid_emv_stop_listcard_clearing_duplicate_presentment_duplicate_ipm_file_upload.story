Narrative:
In order to validate transaction is matched with authorization for Mastercard when presentment is uploaded after card is stop listed
As a Issuer
I want to perform transaction clearing on card which is stoplisted after Authorization

Meta:
@StoryName p_emv_corp_travel
@ClearingNegativeScenario

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
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: 1.5 Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
Then NOT file is successfully generated

Scenario: 1.6 Upload ipm file from customer portal and process it
Meta:
@TestId
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
And transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal

Scenario: 1.8 Update Existing IPM for duplicate presentment
Meta:
@TestId 
When user update IPM file to get status duplicate presentment
Then NOT file is successfully generated


Scenario: 1.9 Upload updated ipm file for duplicate presentment
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
And user processes batch for prepaid
Then user sign out from customer portal


Scenario: 2.0 Verify Transaction Status Duplicate Presentment
Meta:
@TestId 
Given user is logged in institution
When "Matching" batch for prepaid is successful
And transaction status is "Duplicate presentment"
Then user sign out from customer portal

Scenario: 2.1 Update Existing IPM for Unmatch
Meta:
@TestId 
When user update IPM file to get status Unmatch
Then NOT file is successfully generated
And MCPS simulator is closed


Scenario: 2.2 Upload updated ipm file for Unmatch
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
And user processes batch for prepaid
Then user sign out from customer portal


Scenario: 2.3 Verify Transaction Status is Unmatched Presentment
Meta:
@TestId 
Given user is logged in institution
When "Matching" batch for prepaid is successful
And transaction status is "Unmatched Presentment"
Then user sign out from customer portal

Scenario: 2.4 Verify same IPM file is getting failed
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
Then verify processes batch for type prepaid with status FAILED [3]
And user sign out from customer portal
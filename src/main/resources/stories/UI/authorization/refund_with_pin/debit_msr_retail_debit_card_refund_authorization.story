debit msr retail debit card authorization

Narrative:
In order to provide to client easy-to-use debit msr retail debit card
As an issuer
I want to create an magnetic stripe debit msr retail debit card and perform refund transaction

Meta:
@StoryName d_msr_retail
@oldReferenceSheet_debit_msr
@SanityCardsWithAuthorization
@CRCardsWithAuthorizationRefundWithClearing

Scenario: Set up debit msr retail debit card
Meta:
@TestId TC406658
Given user is logged in institution
When device range for program with device plan for "debit" "magnetic stripe" card
Then user sign out from customer portal


Scenario: debit msr retail debit card device production
Meta:
@TestId TC408068
Given user is logged in institution
When user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user has wallet number information for debit device
And user sign out from customer portal
And user is logged in institution
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_REFUND Authorization transaction
Meta:
@TestId 
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
And user processes batch for debit
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for debit is successful
And transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal
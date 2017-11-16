Magnetic Strip Retail Debit Card Authorization & Clearing

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create a magnetic stripe retail debit card and perform transactions and clearing

Meta:
@StoryName debit_msr
@SanityTest
@Authorisation

Scenario: 01 Set up retail magnetic stripe retail debit card 
Meta:
@TestId TC406726

Given user is logged in institution
When device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
When a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
!-- When user sign out from customer portal

Scenario: 02 Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
When connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_WITHDRAWAL MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_ECOMMERCE Authorization transaction
Meta:
@TestId 
When perform an MSR_ECOMMERCE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId 
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed

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
@TestId TC406665
!-- Given user is logged in institution
When NOT file is successfully generated
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId TC406667
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"

Scenario: Program Balance Summary download
Meta:
@TestId 
Then verify report for transactions with Program Balance Summary is downloaded
When user sign out from customer portal
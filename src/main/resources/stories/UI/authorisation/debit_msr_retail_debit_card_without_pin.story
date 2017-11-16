Pinless Magnetic Strip Retail Debit Card Authrization & Clearing

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create a pinless magnetic stripe retail debit card and perform transactions and clearing

Meta:
@StoryName debit_msr
@SanityTest
@Authorisation

Scenario: 01 Set up retail magnetic stripe pinless debit card
Meta:
@TestId TC398508
Given user is logged in institution
When User fills Dedupe Plan
When User fills MCC Rules for debit product
When User fills Transaction Plan for debit product
When User fills Transaction Limit Plan for debit product
When User fills Document Checklist Screen for debit product
When User fills Device Joining and Membership Fee Plan for debit product
When User fills Device Event Based Fee Plan for debit product
When User fills Device Plan for "debit" "magnetic stripe" card with no pin
When User fills Wallet Plan for debit product
When User fills Program section for debit product
When User fills Business Mandatory Fields Screen for debit product
When User fills Device Range section for debit product
When user creates new device of debit type for new client
When a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
!-- When user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId
When perform an MSR_CASH_ADVANCE MAS transaction
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
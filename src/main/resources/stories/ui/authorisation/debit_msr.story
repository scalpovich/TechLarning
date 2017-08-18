Magnetic Strip Debit Card Authrization

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create an magnetic stripe debit card and perform various transaction and perform Clearing

Meta:
@StoryName debit_msr
@SmokeTest

Scenario: Set up retail magnetic stripe debit card 

Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
When a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then embossing file batch was generated in correct format
Then Pin Offset file batch was generated successfully

Scenario: FINSim PIN generation
Given connection to FINSim is established
When PIN is retrieved successfully with sample data from Pin Offset File
Then FINSim simulator is closed

Scenario: MSR_PURCHASE transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction sample
Then MAS test results are verified

Scenario: MSR_CASH_WITHDRAWAL transaction
Given perform an MSR_CASH_WITHDRAWAL MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_ATM_BALANCE_INQUIRY transaction
Given perform an MSR_ATM_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_POS_BALANCE_INQUIRY transaction
Given perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: MSR_ECOMMERCE transaction
Given perform an MSR_ECOMMERCE MAS transaction on the same card
Then MAS test results are verified

Scenario: Auth file creation
Given Auth file is generated
Then FINSim simulator is closed

Scenario: Load ath file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated

Scenario: Load ath file in MCPS and create NOT file of IPM extension
Given connection to MCPS is established
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated

Scenario: Upload ipm file from customer portal and process it
Given user is logged in institution
When NOT file is successfully generated
When User uploads the NOT file
When user processes batch for debit
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Given user is logged in institution
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for debit is successful
Then transaction status is "Presentment Matched with authorization"
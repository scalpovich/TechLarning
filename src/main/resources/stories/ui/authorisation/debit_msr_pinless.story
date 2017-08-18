Magnetic Strip Debit Card Authrization

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create an magnetic stripe debit card and perform various transaction

Meta:
@StoryName debit_msr
@SmokeTest

Scenario: Set up retail magnetic stripe debit card and perform purchase transaction and perform Clearing

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
When User fills Device Range section for debit product
When user creates new device of debit type for new client
When a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
When embossing file batch was generated in correct format
When Pin Offset file batch was generated successfully
When connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
When FINSim simulator is closed
When connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
When Auth file is generated from MAS

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
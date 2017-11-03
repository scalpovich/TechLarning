debit msr retail debit card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose debit card pinless
As an issuer
I want to create a pinless magnetic stripe retail debit card pinless and perform transactions

Meta:
@StoryName debit_msr
@SanityCardsPinlessWithAuthorization

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

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId
When perform an MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
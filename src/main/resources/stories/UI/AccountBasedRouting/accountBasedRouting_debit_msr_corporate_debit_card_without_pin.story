debit MSR corporate card without Pin

Narrative:
In order to check transactions on debit MSR corporate debit
As an issuer
I want to authorize transactions for debit MSR corporate debit

Meta:
@StoryName d_msr_corp_accountRouting
@SanityCardsWithAuthorization
@accountBaseRouting

Scenario: Set up program for debit MSR corporate debit
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
When User filled Device Range section for debit product
When user creates new device of debit type for new client
When user creates Acount Range Routing for CBS1 channel
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit MSR corporate device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH  and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal
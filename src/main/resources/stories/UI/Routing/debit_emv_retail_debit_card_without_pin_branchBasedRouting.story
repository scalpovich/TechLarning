Title: Debit EMV retail debit card authorization pinless

Narrative:
In order to check transactions on debit EMV retail debit card pinless
As an issuer
I want to authorize transactions for debit EMV retail debit card pinless

Meta:
@StoryName d_emv_retail_branchRouting
@branchBaseRouting

Scenario: Set up program for debit EMV retail debit
Given user is logged in institution
When User fills Dedupe Plan
When User fills MCC Rules for debit product
When User fills Transaction Plan for debit product
When User fills Transaction Limit Plan for debit product
When User fills Document Checklist Screen for debit product
When User fills Device Joining and Membership Fee Plan for debit product
When User fills Device Event Based Fee Plan for debit product
When User fills Device Plan for "debit" "emv" card with no pin
When User fills Wallet Plan for debit product
When User fills Program section for debit product
When User fills Business Mandatory Fields Screen for debit product
When User filled Device Range section for debit product
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: Debit EMV retail device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal
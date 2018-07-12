Title : Debit emv corporate debit card withoutPin

Narrative:
In order to check account based routing
As an issuer
I want to perform transactions for debit card
Meta:
@StoryName d_emv_corp_accountRouting
@accountBaseRouting

Scenario: Set up program for debit EMV corporate debit
Given user is logged in institution
When User fills Dedupe Plan
And User fills MCC Rules for debit product
And User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And User fills Device Plan for "debit" "emv" card with no pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User filled Device Range section for debit product
And user creates new device of debit type for new client
And user creates Account Range for Routing for CBS1 channel
Then device has "normal" status
When user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: Debit EMV corporate device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
And processes device production batch for debit
Then device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an EMV_COMPLETION MAS transaction on the same card
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
And user is logged in institution
And search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform ECOMM_PURCHASE Authorization transaction
When perform an ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: MAS is closed
When MAS simulator is closed
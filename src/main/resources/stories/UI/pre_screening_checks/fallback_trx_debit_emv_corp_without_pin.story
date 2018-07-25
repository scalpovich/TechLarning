fallback trx on prepaid emv card corporate travel card with no pin

Narrative:
In order to make fallback transactions on prepaid emv corporate travel card
As an issuer
I want to authorize  fallback transactions for prepaid emv corporate travel card

Meta:
@StoryName @StoryName d_emv_corp
@FallbackTrx
Scenario: Set up program for debit EMV corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device

Scenario: debit EMV corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format

Scenario: Transaction - FALLBACK_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an FALLBACK_PURCHASE MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search FallBack Transaction authorization and verify 000-Successful status
And user sign out from customer portal
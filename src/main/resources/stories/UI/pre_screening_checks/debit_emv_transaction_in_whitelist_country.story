debit emv corporate transaction on white list country

Narrative:
In order to provide to transaction in white/black listed country
As an issuer
I want to make transaction at white listed country via debit card

Meta:
@StoryName d_emv_corp_trx_on_white_list_country
@CountryWhiteBlackListPreScreening

Scenario: Set up program for debit emv corporate debit card
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
And User edit Program to update country white black list
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
Given perform an INT_EMV_PURCHASE MAS transaction on the same card
When user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 25001 AuthDecline Code and Whitelisted Country Not Found as description
Then user sign out from customer portal

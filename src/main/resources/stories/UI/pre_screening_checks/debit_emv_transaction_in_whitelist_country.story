debit emv corporate transaction on white list country

Narrative:
In order to provide to transaction in white/black listed country
As an issuer
I want to make transaction at white listed country via debit card

Meta:
@StoryName d_emv_corp_trx_on_white_list_country


Scenario: Set up program for debit emv corporate debit card
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
Then User edit Program to update country white black list
When User fills Business Mandatory Fields Screen for debit product
When User fills Device Range section for debit product
When user assigns service code to program
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 25001 AuthDecline Code and Whitelisted Country Not Found as description
And user sign out from customer portal

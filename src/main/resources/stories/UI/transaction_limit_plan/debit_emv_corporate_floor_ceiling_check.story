Narrative:
In order to validate floor and ceiling amount of transaction limit plan
As an issuer
I want to perform transaction

Meta:
@StoryName d_emv_corp
@FloorAndCeiling
@debitTxLimits
@Limits

Scenario: 1.1 Set up program for debit EMV corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And user uses existing transaction limit plan for limit type DAILY
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
And user sign out from customer portal

Scenario: 1.2 debit EMV corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
Then user activates device through helpdesk
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction to check Ceiling Amount Check
Given connection to MAS is established
When user updates transaction amount to 105
And perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And assert 34001 response with Decline AuthDecline Code and Transaction amount is greater than per transaction limit configured at device plan level. as description
And user sign out from customer portal

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction to check floor Amount Limit
When user updates transaction amount to 3
And perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert 34000 response with Decline AuthDecline Code and Transaction amount is less than Minimum amount configured at device plan level. as description
And user sign out from customer portal
Narrative:
In order to validate transaction limit, velocity and usage amount
As an issuer
I want to perform transaction

Meta:
@StoryName d_emv_corp
@PeriodicLimit
@DebitTxLimits
@Limits

Scenario: 1.1 Set up program for debit EMV corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And user uses existing transaction limit plan for limit type PERIODIC
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
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When user updates transaction amount to 90
And perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Authorization Search page validation
Given user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.5 Update Transaction Amount More than Allowed Periodic Amount
When user updates transaction amount to 21

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction to check Exceeds Amount Limit
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34005 AuthDecline Code and Transaction exceeded with periodic amount configured at device plan level. as description
And user sign out from customer portal

Scenario: 1.7 Update Transaction Amount Less than Allowed Periodic Amount
When user updates transaction amount to 10
 
Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction with allowed amount
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.9 Perform EMV_PURCHASE Authorization transaction to check Frequency Exceeded
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34004 AuthDecline Code and Transaction exceeded with periodic velocity configured at device plan level. as description
And user sign out from customer portal
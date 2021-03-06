Narrative:
In order to validate transaction limit, velocity and usage amount
As an issuer
I want to perform transaction

Meta:
@StoryName prepaid_emv_retail_Limits
@INT_DailyLimit
@PrepaidTxLimits
@Limits

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And user uses existing transaction limit plan for limit type INT_DAILY
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform INT_EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When user updates transaction amount to 15
And perform an INT_EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Authorization Search page validation
Given user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user validates available balance for prepaid product on helpdesk
And user sign out from customer portal

Scenario: 1.5 Update Transaction Amount More than Allowed Periodic Amount
When user updates transaction amount to 10

Scenario: 1.6 Perform INT_EMV_PURCHASE Authorization transaction to check Exceeds Amount Limit
Given perform an INT_EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34003 AuthDecline Code and Transaction exceeded with Daily amount configured at device plan level. as description
And user validates available balance for prepaid product on helpdesk
And user sign out from customer portal

Scenario: 1.7 Update Transaction Amount Less than Allowed Periodic Amount
When user updates transaction amount to 2
 
Scenario: 1.8 Perform INT_EMV_PURCHASE Authorization transaction with allowed amount
Given perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user validates available balance for prepaid product on helpdesk
And user sign out from customer portal

Scenario: 1.9 Perform INT_EMV_PURCHASE Authorization transaction to check Frequency Exceeded
Given perform an INT_EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34002 AuthDecline Code and Transaction exceeded with daily velocity configured at device plan level. as description
And user validates available balance for prepaid product on helpdesk
And user sign out from customer portal
And MAS simulator is closed
Narrative:
In order to validate floor and ceiling amount of transaction limit plan
As an issuer
I want to perform transaction

Meta:
@StoryName prepaid_emv_retail_Limits
@DailyLimit
@PrepaidTxLimits
@Limits

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And user uses existing transaction limit plan for limit type DAILY
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
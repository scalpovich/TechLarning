prepaid card transaction in white/black listed country

Narrative:
In order to provide to transaction at white listed country
As an issuer
I want to make transaction at white listed country via prepaid card

Meta:
@StoryName prepaid_card_trx_at_white_list_country
@CountryWhiteBlackListPreScreening
Scenario:1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card
And User fills Wallet Plan for prepaid product
When User fills MCC Rules for prepaid product
And User fills Program section for prepaid product
And User edits Program to update country white and black list
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario:1.1 Device Production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario:1.2 Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:1.4 Perform INT_MSR_PURCHASE Authorization transaction
Given perform an INT_MSR_PURCHASE MAS transaction on the same card
When MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 25001 AuthDecline Code and Whitelisted Country Not Found as description
Then user sign out from customer portal
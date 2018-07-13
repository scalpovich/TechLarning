prepaid emv corporate general purpose card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate general purpose card and test various transactions

Meta:
@StoryName p_emv_corp_general_purpose

Scenario: Adding TransactionLimitPlan, card management tab
Given user is logged in institution
When user is at the home tab
And User fills Transaction Limit Plan for prepaid product without details
And User fills details for Account Funding [AF] for All [~] source
And User fills details for Initial Load [IL] for All [~] source
And User fills details for Purchase/Auth Completion [01] for All [~] source
And User saves plan
Then user signs out from customer portal

Scenario: Card Setup
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" with limit plan
Then user sign out from customer portal

Scenario: Card Setup 2
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Perform MMSR-CORPORATE_TravelCard Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Assert Authorization Search and Device Usage
Given user is logged in institution
Then search MasterCard MoneySend  authorization and verify Successful status
Then user searches device on device usage screen and performs assertions on device total usage
And user searches device on device usage screen and performs assertions on device transaction usage
And user sign out from customer portal
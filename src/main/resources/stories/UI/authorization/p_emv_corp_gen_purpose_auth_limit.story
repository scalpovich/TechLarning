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
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Card Creation
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Transaction EMV_PURCHASE
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify Successful status
!-- When User deleted PRE_TLP plan
And user sign out from customer portal
And MAS simulator is closed
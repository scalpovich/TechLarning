Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
So that the Loyalty points can be calculated and can be redeemed by the user
Meta:
All				 
Scenario: Loyalty program setup
Meta:
@CR
@PrepaidProgramCorporateGeneralSingleWallet
@TCName TC264328_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user adds loyalty Plan
When user adds promotion Plan
When user maps promotion Plan with loyalty Plan
When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose
Then Program should get created




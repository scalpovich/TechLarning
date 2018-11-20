add transactions in TLP

Narrative:
In order to provide a flexibility to add multiple transactions
As an issuer
I want to create a transaction limit plan

Meta:
@StoryName p_emv_corp_general_purpose

Scenario: TransactionLimitPlan
Given user is logged in institution
When user is at the home tab
And User fills Transaction Limit Plan for prepaid product without details
And User fills details for Account Funding [AF] for All [~] source
And User fills details for Initial Load [IL] for All [~] source
And User fills details for Purchase/Auth Completion [01] for All [~] source
And User saves plan
Then user signs out from customer portal
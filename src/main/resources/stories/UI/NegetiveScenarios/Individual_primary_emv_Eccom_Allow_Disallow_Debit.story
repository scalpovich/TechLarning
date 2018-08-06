Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to assert Pre-Screenning Checks by doing various transactions.

Meta:
@StoryName d_emv_corp
@SanityCardsWithAuthorization
@EMVWithPin
@PreScreening
Scenario: Set up program for debit emv corporate debit card
Given user is logged in institution
When device range for program with device plan for "debit" "emv" card
Then user sign out from customer portal
Given user is logged in institution
When user creates new device of debit type for new client
Then device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user selects E-commerce Activation/Deactivation [304] status
And user activates device through helpdesk
And embossing file batch was generated in correct format

Scenario: Perform ECCOM_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 119-Transaction not permitted status
Then assert Decline response with 46008 AuthDecline Code and E-Comm transaction not allowed. as description
Then user sign out from customer portal

Scenario: Perform ECCOM Allow/DisAllow for one hour
Given user is logged in institution
When user allow E-commerce Activation/Deactivation [304] Transaction For One Hour
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
When perform an ECOMM_PURCHASE MAS transaction on the same card
And user is logged in institution
Then search ECCOM-PURCHASE authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Wait for 1 hour and Then Perform Purchase Transaction
When user wait for one hour to perform transaction
And perform an ECOMM_PURCHASE MAS transaction on the same card
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 119-Transaction not permitted status
Then assert Decline response with 46008 AuthDecline Code and E-Comm transaction not allowed. as description
And user sign out from customer portal
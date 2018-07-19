Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@Pre-ScreeningCheck
@StoryName p_emv_corp_travel				 
@PreScreening

Scenario: Set up prepaid emv corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
When user selects E-commerce Activation/Deactivation [304] status
Then user sign out from customer portal
When embossing file batch was generated in correct format

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

Scenario: Perform INT_ECCOM_PURCHASE Authorization transaction
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
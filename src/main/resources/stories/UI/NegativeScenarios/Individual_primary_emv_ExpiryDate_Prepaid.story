Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to assert Pre-Screenning Checks by doing various transactions.

Meta:
@Pre-ScreeningCheck
@StoryName p_emv_corp_travel				 
@PreScreening

Scenario:1.1 Set up prepaid emv corporate travel card
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario:1.2 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user has wallet number information for prepaid device
And user sign out from customer portal
And user is logged in institution
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
And User enters incorrect Expiry Date

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 101-EXPIRED CARD status
Then assert Decline response with 20005 AuthDecline Code and Device is expired. as description
And user sign out from customer portal
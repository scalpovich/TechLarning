Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:  
@UserJourney
@StoryName InstitutionSetup
 
Scenario: Institution Creation and Setup
Meta:
@InstitutionSetup
@InstitutionUserSetupAndAssignPrivlidges
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName InstituteSetup
Given login to bank as a Bankadmin
When user creates Prepaid institution and a user
Then user logouts from customer portal
Given login to bank as a Bankadmin
When user select the created institution from the institution dropdown
When admin provides the screen level privileges for the the newly created user
And admin provides the report level privileges for the the newly created user
And admin provides batch level privileges for the the newly created User
And admin provides the helpdesk level privileges - User Groups for the the newly created user
And admin provides the helpdesk level privileges - Assign Product for the the newly created user
And admin provides the helpdesk level privileges - Assign Service Code for the the newly created user
Then user logouts from customer portal
When user logs in again with the new user
And the newly created institution is selected
And user creates a Network MemberShip for Mastercard
And user creates a Network MemberShip for Rupay
And the user navigates and adds account head to the system
And the user navigates and adds account master to the system
And the user navigates and adds account head mapping to the system
!-- And user sets the upload batch definiton for the Currency Exchange Rate upload file
!-- And user uploads the CER file for bank
And user creates CER mapping for system and mastercard through screen
And user creates Device BIN for Rupay for product Debit for BinType as Dual Message Type
And user adds the RuPay Settlement BIN
!-- And user adds an Event and Alert in the system


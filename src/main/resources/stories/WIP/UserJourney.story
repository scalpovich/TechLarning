Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:  
@UserJourney
 
Scenario: User Journey: Prepaid MagStripe card
Meta:
@MIDeviceCreationdebitHelpdesk
Given User creates Prepaid institution
And User creates new user 


Given login to portal as existing bank as a Customeruser

When user creates institution setup for prepaid type mastercard
When user creates CER mapping for System and Bank through screen
When user creates currency exchange rates for Mastercard through screen
When user configures the device range for Corporate Travel card, single wallet single currency for MagStripe
Then user should be able to create Magnetic Stripe for Prepaid product for Corporate customer


Scenario: User Journey: New Application
Meta:
@MIDeviceCreationdebitHelpdesk
Given login to portal as existing bank as a Customeruser
When user creates institution setup for prepaid type mastercard
When user creates CER mapping for System and Bank through screen
When user creates currency exchange rates for Mastercard through screen
When user configures the device range for Corporate Travel card, single wallet single currency for MagStripe
Then user creates a new application for Magnetic Stripe card Card for Prepaid product for Corporate customer 


Scenario: User Journey: Application upload
Meta:
@MIDeviceCreationdebitHelpdesk
Given login to portal as existing bank as a Customeruser
When user creates institution setup for prepaid type mastercard
When user creates CER mapping for System and Bank through screen
When user creates currency exchange rates for Mastercard through screen
When user creates Application Upload Prepaid batch file and uploads it on server

Scenario: Institution Creation and Setup
Meta:
@InstitutionSetup
@InstitutionUserSetupAndAssignPrivlidges
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
Given login to bank as a Bankadmin
When user creates Prepaid institution and a user
And admin provides the screen level privileges for the the newly created user
And admin provides the report level privileges for the the newly created user
And admin provides batch level privileges for the the newly created user
And admin provides the helpdesk level privileges - User Groups for the the newly created user
And admin provides the helpdesk level privileges - Assign Product for the the newly created user
And admin provides the helpdesk level privileges - Assign Service Code for the the newly created user
And user creates institution setup for prepaid type mastercard


Scenario: Institution Creation and Setup
Meta:
@InstitutionSetup
@InstitutionUserSetupAndAssignPrivlidges
@TCName TCInstituteCreationDC
@testDataFileName testdata
@sheetName Institute
Given login to bank as a Bankadmin
When user creates Debit institution and a user
And admin provides the screen level privileges for the the newly created user
And admin provides the report level privileges for the the newly created user
And admin provides batch level privileges for the the newly created user
And admin provides the helpdesk level privileges - User Groups for the the newly created user
And admin provides the helpdesk level privileges - Assign Product for the the newly created user
And admin provides the helpdesk level privileges - Assign Service Code for the the newly created user
And user creates institution setup for prepaid type mastercard




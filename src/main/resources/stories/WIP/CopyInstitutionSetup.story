Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:  
@UserJourney
@StoryName HelpdeskPrivileges
 
Scenario: Institution Creation and Setup
Meta:
@InstitutionSetup
@InstitutionUserSetupAndAssignPrivlidges
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName InstituteSetup
Given login to portal as existing bank as a user
When user sets the upload batch definiton for the Currency Exchange Rate upload file
And user navigates to the Process Batches screen
And user uploads the currency exchange rates file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the CurrencyExchangeRate file is uploaded sucessfully

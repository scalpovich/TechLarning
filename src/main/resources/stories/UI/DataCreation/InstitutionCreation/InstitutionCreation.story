Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate New Users and Institution Creation. 

Meta:
@UI
@all
@InstitutionAndUserCreation

Scenario:1 New Institution creation prepaid

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
@PrepaidInstitutionAndUserCreation
@all

Given login to bank as a Bankadmin
When user enter details to create new Prepaid Institution
Then user should be able to create new institute
When user enter details to create new user
Then user should be able to create new user

Scenario:2 New Institution creation Debit

Meta:
@TCName TCInstituteCreationDC
@testDataFileName testdata
@sheetName Institute
@DebitInstitutionAndUserCreation
@all

Given login to bank as a Bankadmin
When user enter details to create new Debit Institution
Then user should be able to create new institute
When user enter details to create new user
Then user should be able to create new user


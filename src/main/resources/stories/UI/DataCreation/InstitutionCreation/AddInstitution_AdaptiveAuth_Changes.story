Institution and user creation story

Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate New Users and Institution Creation. 

Meta:
@UI
@all
@StoryName InstitutionAndUserCreation
@InstitutionAndUserCreation

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
@PrepaidInstitutionCreation

Given login to bank as a Bankadmin
When user enters details to create new Prepaid Institution
Then user should be able to create new institute
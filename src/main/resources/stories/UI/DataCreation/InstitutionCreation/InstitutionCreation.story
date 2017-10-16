Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate New Users and Institution Creation. 

Meta:
@UI
@all
@TCInstitutionUserIntegration

Scenario:1 New Institution creation 

Meta:
@TCName TC1InstituteCreation
@testDataFileName testdata
@sheetName Institute
@TC1234
@all
!--Given login to existing bank as a Admin
Given login to bank as a Bankadmin
When user enter details to create new Prepaid Institution
Then user should be able to create new institute
When user enter details to create new user
Then user should be able to create new user


Given Bankadmin creates Prepaid institution
And Bankadmin creates new user

Scenario:2 New User creation 

Meta:
@TCName TC_UserCreation
@sheetName UserCreation
@TC2


Then user should be able to create new Users

Scenario: Assign newly created user to newly created institution

Meta:
@TCName TC_UserCreation
@sheetName UserCreation
@TC3

Given login to portal as existing bank as a user
When admin assigns new institution to the user
Then user should get updated with successful $Message
|Record Updated Successfully.|

Scenario: Assign Screen-Privileges

Meta:
@TCName InstitutePrivileges
@sheetName AssignScreenPrivileges
@TC4

Given login to portal as existing bank as a user
When admin gives screen privileges to new Institution
Then user should get updated with successful $Message
|Privileges assigned successfully,Group/User has to re-login to see the changes.|
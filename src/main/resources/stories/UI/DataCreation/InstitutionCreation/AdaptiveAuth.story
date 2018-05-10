Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that use RSA Auth 

Meta:
@RSA_Auth

Scenario:Enable RSA authentication at Institution level 

Meta:
@TCName TC1InstituteCreation
@testDataFileName testdata
@sheetName Institute
@RSA_Auth_Institution
Given login to bank as a Bankadmin
When user searches for the institution
And select the RSA Auth at institution level
Then verify that RSA Auth is enabled at institution level
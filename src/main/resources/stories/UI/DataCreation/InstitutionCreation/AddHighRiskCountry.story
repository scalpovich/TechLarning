High Risk Country creation story

Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate High Risk Country creation 

Meta:
@UI
@all
@StoryName InstitutionAndUserCreation

Scenario:add high risk country

Meta:
@TCName TC_Application_Upload_Prepaid
@testDataFileName testdata
@sheetName Prepaid_Application_Upload 
Given login to portal as existing bank as a Customeruser
When user Adds CANADA [124] as High Risk Country
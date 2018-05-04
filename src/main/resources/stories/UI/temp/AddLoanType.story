loan type creation story

Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate loan type creation

Meta:
@UI
@all
@StoryName addLoanType



Scenario:add loan type

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
Given login to bank as a customerUser
When user adds loan type

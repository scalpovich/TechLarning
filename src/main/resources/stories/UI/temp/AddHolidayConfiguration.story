holiday configuration creation story

Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate holiday configuration creation

Meta:
@UI
@all
@StoryName addHolidayConfiguration

Scenario:add holiday configuration

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute 
Given login to bank as a customerUser
When user adds holiday configuration

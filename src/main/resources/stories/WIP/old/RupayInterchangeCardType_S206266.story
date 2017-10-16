Narrative:
As a(n) bank user
I have an option to classify device ranges 
So that rupay variants given for each range can be tagged on our platform 

Meta:
@all
@UI
@RupayInterchangeType
@R6releaseAutomation

Scenario: Rupay Interchange Card Type
Meta:
@Regression
@Smoke
@TC264211
@sheetName S205000
@TCName TC264211_Rupay Interchange Card Type options validation
Given login to existing bank as a user
When user is configuring device ranges and selects rupay network
Then following options needs to appear for Rupay network:
|interchange|
|Rupay Classic|
|Rupay Platinium|
|Rupay Select|


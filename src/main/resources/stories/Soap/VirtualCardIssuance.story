Narrative: 
As a User
I want to do Virual card boarding  
In order to check API response

Meta: 
@S181557
Scenario: Virtual Card boarding via Virtual Card Issuance API
Given I have a valid web service request loginRequest.xml
Then I send the request
Then I need to save sessionKey for future steps
Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|

When I have a valid web service request VirtualCardIssuance.xml
Then I update xml for below tags: 
|tags|
|sessionKey|
|traceAuditNumber|
|rrn|

Then I send the request
Then I need to save sessionKey for future steps
Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL|
|errorCode|000|


 




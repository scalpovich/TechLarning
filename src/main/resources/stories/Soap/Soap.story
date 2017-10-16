

Narrative: afslkfj
As a User
I want to do something
In order to have something else han

Meta:
@soap
@storyType API


Scenario: LoginRequest

Given I have a valid web service request loginRequest.xml
Then I send the request
Then I need to save sessionKey for future steps

Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|



Scenario: Load Reload via API (Transaction)

Given I have a valid web service request Load_Reload.xml

Then I update xml for below tags: 
|tags|
|sessionKey|
|traceAuditNumber|
|rrn|

Then I send the request


Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|



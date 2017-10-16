Narrative: afslkfj
As a User
I want to do something
In order to have something else han

Meta:
@soapStage
@storyType API


Scenario: LoginRequest

Given I have a valid web service request loginRequest.xml
When I update login xml for below tags: 
|tags|value |
|componentId|NA|
|componentAuthKey|NA|
|userId|NA|
|password|NA|
|ip|NA|
|bankCode|NA|
And I send the request
And I need to save sessionKey for future steps
Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|


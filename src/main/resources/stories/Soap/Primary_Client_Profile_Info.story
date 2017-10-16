Narrative: 
As a API User
I want to get Client Profile Info


Meta:
@soapDemo
@storyType API
@ClientProfileInfo
@CentaurusAPI

Scenario: Login Request

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

Scenario: Primary Client Profile Info

Given I have a valid web service request PrimaryClientProfInfo.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|formFactor|4799681120404003|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDescription|Successful|
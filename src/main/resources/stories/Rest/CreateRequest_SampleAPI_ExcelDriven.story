Narrative: afslkfj
As a User
I want to Execute multiple API
In order to Validate json respose

Meta:
@StoryName post_Data
@storyType API

Scenario: update sample json and validate response
Meta:
@datasheet post_Data
Given user create json request
When user send post request at users
Then Validate Response for below Attributes:
|AttributesToValidate|
|name=Updated name|
|email=Updatedemail@.com|
|address.city=pune|
|address.street=yerwada|
|address.geo.lng=12345|
|address.geo.lat=45678|
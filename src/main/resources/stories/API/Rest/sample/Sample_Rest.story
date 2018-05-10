Narrative:
As a User
I want to Execute multiple API
In order to Validate json response

Meta:
@SampleAPI
@storyType API
@storyName

Scenario: Validate user Response's attribute
Meta:
@Scenario1
@testapi

Given user updates sample.json with below Attributes:
|AttributesToUpdate|
|id=11|
|name=Updated name|
|email=Updatedemail@.com|
|address:city=pune|
|address:street=yerwada|
|address,geo:lng=12345|
|address,geo:lat=45678|
When user sends post request with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|name=Updated name|
|email=Updatedemail@.com|
|address.city=pune|
|address.street=yerwada|
|address.geo.lng=12345|
|address.geo.lat=45678|

Scenario: Validate user Response's attributes
Meta:
@Scenario2

Given user updates sample.json with <field>
When user sends post request
Then Validate Response for <validate>
Examples:
|field|validate|
|address,geo:lng=12345|address.geo.lng=12345|
|address:city=pune|address.city=pune|
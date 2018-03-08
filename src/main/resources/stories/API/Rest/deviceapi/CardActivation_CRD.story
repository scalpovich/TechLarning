Narrative:
As a User
I want to Execute multiple API
In order to Validate json response

Meta:
@CA_Scenarios
@storyType API

Meta:
@CA2
Given user updates CardActivation_CRD_Request.json with <field>
When user sends put request
Then Validate Response for <validate>
Examples:
|field|validate|
|formFactor=abc|messageText=Device is Activated Successfully|
|formFactor=null|messageText=Device Number is of invalid format|
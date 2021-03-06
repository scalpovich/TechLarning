Narrative:
As a User
I want to Execute multiple API
In order to Validate json response

Meta:
@CA_Scenarios
@storyType API

Meta:
@API_Scenarios
Given user updates CardActivation_CRD_Request.json with <field>
When user sends put request
Then Validate Response for <validate>
Examples:
|field|validate|
|formFactor=ActivatedCRD|messageText=Device is already Activated|
|formFactor=Stoplisted|messageText=Device is stoplisted.|
|formFactor=Cancelled|messageText=Device is Cancelled|
|formFactor=Expired|messageText=Device is Expired|
Narrative: afslkfj
As a User
I want to Execute multiple API
In order to Validate json respose

Meta:
@CA_Scenarios
@storyType API

Meta:
@API_Scenarios
Given user update CardActivation_CRD_Request.json with <field>
When user send put request
Then Validate Response for <validate>
Examples:
|field|validate|
|formFactor=ActivatedCRD|messageText=Device is already Activated|
|formFactor=Stoplisted|messageText=Device is stoplisted.|
|formFactor=Cancelled|messageText=Device is Cancelled|
|formFactor=Expired|messageText=Device is Expired|
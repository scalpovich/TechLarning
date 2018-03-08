Narrative:
As a User
I want to Execute multiple API
In order to Validate json response

Meta:
@CA_Scenarios
@storyType API

Meta:
@CA1
Given user updates CardActivation_CPI_Request.json with <field>
When user sends put request
Then Validate Response for <validate>
Examples:
|field|validate|
|formFactor=ActivateCPI|messageText=Device is Activated Successfully|
|formFactor=null|messageText=Invalid Card Pack Id|
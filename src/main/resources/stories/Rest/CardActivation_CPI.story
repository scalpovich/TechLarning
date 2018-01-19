Narrative: afslkfj
As a User
I want to Execute multiple API
In order to Validate json respose

Meta:
@CA_Scenarios
@storyType API

Meta:
@CA1
Given user update CardActivation_CPI_Request.json with <field>
When user send put request
Then Validate Response for <validate>
Examples:
|field|validate|
|formFactor=ActivateCPI|messageText=Device is Activated Successfully|
|formFactor=null|messageText=Invalid Card Pack Id|
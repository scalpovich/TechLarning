Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@RegisteredEmailID
@StoryName S341735
	
Scenario: Raise service request
Given user is logged in institution
When user creates service request to change the registered mobile number
Then user sign out from customer portal

Scenario: Validate Service request details
Given user is logged in institution
When user validates registered mobile number update screen with the required fields
Then user sign out from customer portal
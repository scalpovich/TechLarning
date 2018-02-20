!-- author: e076168
Narrative:
In order to add new device from data provided
As a user
I want to assert that newly created device is present into the system

Meta:
@StoryName NewDeviceCredit

Scenario: Create new device from data sheet
Given user is logged in institution
Then credit device is created using new device screen by data driven
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
When user performs adjustment transaction
Then user sign out from customer portal
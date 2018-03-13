!-- author: e076168
Narrative:
In order to add new device from data provided
As a user
I want to assert that newly created device is present into the system and able to perform the transaction

Meta:
@StoryName NewDeviceCredit_individual_emv

Scenario: Create new device from data sheet
Given user is logged in institution
When credit device is created using new device screen by data driven without Pin
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL
When user performs adjustment transaction
Then user sign out from customer portal

Scenario:Connect to MAS Simulator and perform the transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
Then MAS simulator is closed

Scenario:Verify the transaction on Authorization search on customer portal
Given user is logged in institution
Then search Purchase authorization and verify Successful status
And user sign out from customer portal
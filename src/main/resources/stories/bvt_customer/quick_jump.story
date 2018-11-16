Narrative:
In order to validate the quick jump functionality
As a user
I want to assert all quick jump page codes

Meta:
@BVTQuickJump

Scenario:1 User logs in to Customer portal
Given user is logged in institution

Scenario:2 Validation of Quick Jump functionality
When user tries quick jump for page <code>
Then respective page <name> should be present

Examples:
|code|name|
|M00000|Go|
|ISW008|Device Joining and Membership Fee Plan|
|DDPLN001|Dedupe Plan|

Scenario:3 User logs out from Customer portal
When user sign out from customer portal
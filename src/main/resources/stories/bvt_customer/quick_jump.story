Narrative:
In order to validate the quick jump functionality
As a user
I want to assert all quick jump page codes

Meta:
@BVTQuickJump
		 
Scenario: Validation of Quick Jump functionality
Given user is logged in institution
When user tries quick jump for page <code>
Then respective page <name> should be present

Examples:
|code|name|
|ISAS01|Stop List Device|
|LOAE03|Reward Redemption|
Smoke Testing of collect portal report tab

Narrative:
In order to verify that all pages of collect portal report tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CollectSmoke

Scenario: UI verfication of StatCard, Report tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then StatCard page of report tab is rendered correctly

Scenario: UI verfication of Reports, Report tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then Reports page of report tab is rendered correctly
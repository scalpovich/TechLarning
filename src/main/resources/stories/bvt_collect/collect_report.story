Narrative:
In order to verify that all pages of collect portal report tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CollectBV

Scenario: UI verification - Collect Portal -  StatCard, Report tab
Meta:
@TestId TC379216
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then StatCard page of report tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  Reports, Report tab
Meta:
@TestId TC379215
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then Reports page of report tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  Home Page
Meta:
@TestId TC379214
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then Home page is rendered correctly
And user signs out from collect portal
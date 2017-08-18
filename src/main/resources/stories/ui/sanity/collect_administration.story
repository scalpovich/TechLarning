Smoke Testing of collect portal administration tab

Narrative:
In order to verify that all pages of collect portal administration tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CollectSmoke

Scenario: UI verfication of AdministrationHome, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then AdministrationHome page of administration tab is rendered correctly

Scenario: UI verfication of AgencyCreation, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then AgencyCreation page of administration tab is rendered correctly

Scenario: UI verfication of Audit, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then Audit page of administration tab is rendered correctly

Scenario: UI verfication of GroupCreation, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then GroupCreation page of administration tab is rendered correctly

Scenario: UI verfication of ReportPrivileges, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ReportPrivileges page of administration tab is rendered correctly

Scenario: UI verfication of ResetPassword, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ResetPassword.java page of administration tab is rendered correctly

Scenario: UI verfication of ScreenPrivileges, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ScreenPrivileges page of administration tab is rendered correctly

Scenario: UI verfication of UserCreation, Administration tab
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then UserCreation page of administration tab is rendered correctly
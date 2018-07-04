Narrative:
In order to verify that all pages of collect portal administration tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CollectBV

Scenario: UI verification - Collect Portal -  AdministrationHome, Administration tab
Meta:
@TestId TC379190
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then AdministrationHome page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  AgencyCreation, Administration tab
Meta:
@TestId TC379192
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then AgencyCreation page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  Audit, Administration tab
Meta:
@TestId TC379193
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then Audit page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  GroupCreation, Administration tab
Meta:
@TestId TC379194
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then GroupCreation page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  ReportPrivileges, Administration tab
Meta:
@TestId TC379195
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ReportPrivileges page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  ResetPassword, Administration tab
Meta:
@TestId TC379191
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ResetPassword page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  ScreenPrivileges, Administration tab
Meta:
@TestId TC379196
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then ScreenPrivileges page of administration tab is rendered correctly
And user signs out from collect portal

Scenario: UI verification - Collect Portal -  UserCreation, Administration tab
Meta:
@TestId TC379197
Given user is on login page of collect portal
And user logs in with valid credentials
When user is logged into collect portal successfully
Then UserCreation page of administration tab is rendered correctly
And user signs out from collect portal
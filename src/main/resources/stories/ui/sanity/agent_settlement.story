Smoke Testing of agent portal settlement tab

Narrative:
In order to work on Agent Portal
As an Agent User
I want to validate settlement tab Agent Portal Pages Loaded based on roles Admin, Agency

Meta:
@StoryName S224290
@SmokeTest
@AgentSmoke

Scenario: Agent Portal - Settlement - Initiate - Agency Settlement Page

Given user is logged in agent portal as agency user
When user navigates to initiate settlement page
Then initiate settlement page is loaded and master detail content title is Initiate Settlement
And InitiateSettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Settlement - Reports - Agency Settlement Page

Given user is logged in agent portal as admin user
When user navigates to agency settlement page
Then agency settlement page is loaded and master detail content title is Initiate Settlement Reports
And AgencySettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Settlement - Reports - Branch Settlement Page

Given user is logged in agent portal as agency user
When user navigates to branch settlement page
Then branch settlement page is loaded and master detail content title is Initiate Settlement Reports
And BranchSettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Settlement - Reports - Transaction & Settlement Page

Given user is logged in agent portal as agency user
When user navigates to transaction and settlement page
Then transaction and settlement page is loaded and master detail content title is Transaction Settlement Reports
And TransactionAndSettlement page of settlement tab is rendered correctly
And user sign out from agent portal
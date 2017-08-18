Smoke Testing of agent portal profile tab

Narrative:
In order to work on Agent Portal
As an Agent User
I want to validate profile tab Agent Portal Pages Loaded based on roles Admin, Agency, Agent, Branch

Meta:
@StoryName S224290
@SmokeTest
@AgentSmoke

Scenario: Agent Portal - Profile - View Profile Page

Given user is logged in agent portal as <type> user
When user navigates to view profile page
Then view profile page is loaded and master detail content title is Profile Information
And ViewProfile page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: Agent Portal - Profile - Entity Details Page

Given user is logged in agent portal as <type> user
When user navigates to entity details page
Then entity detials page is loaded and master detail content title is <expectedvalue>
And EntityDetails page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |        expectedvalue	      |
| agency | Agency Profile Information |
| branch | Branch Profile Information |
| agent  | Agent Profile Information  |

Scenario: Agent Portal - Profile - Change Password Page

Given user is logged in agent portal as agent user
When user navigates to change password page
Then change password page is loaded and master detail content title is Change Password
And ChangePassword page of profile tab is rendered correctly
And user sign out from agent portal
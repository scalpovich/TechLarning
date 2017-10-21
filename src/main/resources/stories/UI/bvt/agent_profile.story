Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate profile tab UI verification Agent Portal Pages Loaded based on roles Admin, Agency, Agent, Branch

Meta:
@StoryName S224290
@AgentBV


Scenario: UI verification Agent Portal - Profile - View Profile Page
Given user is logged in agent portal as <type> user
When user navigates to view profile page
Then view profile page is loaded and master detail content title is Profile Information
And ViewProfile page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
{metaByRow=true}
|Meta:           | type   |
|@TestId TC378867| admin  |
|@TestId TC411887| agency |
|@TestId TC411888| branch |
|@TestId TC411889| agent  |

Scenario: UI verification Agent Portal - Profile - Entity Details Page
Given user is logged in agent portal as <type> user
When user navigates to entity details page
Then entity detials page is loaded and master detail content title is <expectedvalue>
And EntityDetails page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
{metaByRow=true}
|Meta:           | type   |        expectedvalue	   |
|@TestId TC378866| agency | Agency Profile Information |
|@TestId TC411890| branch | Branch Profile Information |
|@TestId TC411891| agent  | Agent Profile Information  |

Scenario: UI verification Agent Portal - Profile - Change Password Page
Meta:
@TestId TC378865
Given user is logged in agent portal as agent user
When user navigates to change password page
Then change password page is loaded and master detail content title is Change Password
And ChangePassword page of profile tab is rendered correctly
And user sign out from agent portal
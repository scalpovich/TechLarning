Narrative:
In order to perform user activities
As a user
I want to have access to portal

Meta:
@StoryName S182414
@SanityUserManagement
@FullSanity

Scenario: Non-UI Verification - Successful login to customer portal
Meta:
@TestId TC398150
Given user is on login page of customer portal
When user logs in with valid credentials
Then user is logged into customer portal successfully

Scenario: Non-UI Verification - Successful login to cardholder portal
Meta:
@TestId TC406080
Given user is on login page of cardholder portal
When user logs in with valid credentials
Then user is logged into cardholder portal successfully

Scenario: Non-UI Verification - Successful login to agent portal
Given user is on login page of agent portal
When user logs in with valid credentials as <type> user
Then user is logged into agent portal successfully
And user sign out from agent portal

Examples:
{metaByRow=true}
|Meta:           | type   |
|@TestId TC406081| admin  |
|@TestId TC411892| agency |
|@TestId TC411893| branch |
|@TestId TC411894| agent  |

!-- Scenario: Non-UI Verification - Successful login to collect portal
!-- Meta:
!-- @TestId TC406082
!-- Given user is on login page of collect portal
!-- When user logs in with valid credentials
!-- Then user is logged into collect portal successfully

Scenario: Non-UI Verification - Default institute selected in list of available institutions on login to customer portal
Meta:
@TestId TC406085
Given user is on login page of customer portal
When user logs in with valid credentials
Then list of available institutions is displayed
And default institution is selected

Scenario: Non-UI Verification - Select institution on login to customer portal
Meta:
@TestId TC406086
Given user is on login page of customer portal
When user logs in with valid credentials
And user confirms selection of institution
Then selected institution page is displayed

Meta:
@TestId TC406087
Given user is on login page of customer portal
When user logs in with incorrect password
Then user sees message that user name or password is incorrect

Scenario: Non-UI Verification - Cannot login with incorrect password
Meta:
@TestId TC411895
Given user is on login page of cardholder portal
When user logs in with incorrect password
Then user sees message that user name or password is incorrect for cardholder portal

Scenario: Non-UI Verification - Cannot login with incorrect password for collect portal
Meta:
@TestId TC411896
Given user is on login page of collect portal
When user logs in with incorrect password
Then user sees message that user name or password is incorrect for collect portal


Scenario: Non-UI Verification - Cannot login with incorrect password for agent portal
Given user is on login page of agent portal
When user logs in with incorrect password as <type> user
Then user sees message that user name or password is incorrect on agent portal

Examples:
!-- {metaByRow=true}
|Meta:           | type   |
|@TestId TC406088| admin  |
|@TestId TC411897| agency |
|@TestId TC411898| branch |
|@TestId TC411899| agent  |
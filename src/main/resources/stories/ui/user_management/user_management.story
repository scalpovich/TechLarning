User Management

Narrative:
In order to perform user activities
As a user
I want to have access to portal

Meta:
@StoryName S182414
@SmokeTest

Scenario: Successful login to customer portal

Given user is on login page of customer portal
When user logs in with valid credentials
Then user is logged into customer portal successfully

Scenario: Successful login to cardholder portal

Given user is on login page of cardholder portal
When user logs in with valid credentials
Then user is logged into cardholder portal successfully

Scenario: Successful login to agent portal

Given user is on login page of agent portal
When user logs in with valid credentials
Then user is logged into agent portal successfully

Scenario: Successful login to collect portal

Given user is on login page of collect portal
When user logs in with valid credentials
Then user is logged into collect portal successfully

Scenario: Default institute selected in list of available institutions on login to customer portal

Given user is on login page of customer portal
When user logs in with valid credentials
Then list of available institutions is displayed
And default institution is selected

Scenario: Select institution on login to customer portal

Given user is on login page of customer portal
When user logs in with valid credentials
And user confirms selection of institution
Then selected institution page is displayed

Scenario: Cannot login with incorrect password

Given user is on login page of <type> portal
When user logs in with incorrect password
Then user sees message that user name or password is incorrect

Examples:
| type       |
| customer   |
| agent      |
| cardholder |
| collect    |

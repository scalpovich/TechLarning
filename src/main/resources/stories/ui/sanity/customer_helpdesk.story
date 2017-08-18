Smoke Testing of customer portal helpdesk tab

Narrative:
In order to verify that all pages of customer portal helpdesk tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CustomerSmoke


Scenario: UI verfication of CustomerCare, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then CustomerCare page of helpdesk tab is rendered correctly

Scenario: UI verfication of DynamicQuizzing, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then DynamicQuizzing page of helpdesk tab is rendered correctly

Scenario: UI verfication of EscalationII, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then EscalationII page of helpdesk tab is rendered correctly

Scenario: UI verfication of EscalationI, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then EscalationI page of helpdesk tab is rendered correctly

Scenario: UI verfication of Forwarded, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then Forwarded page of helpdesk tab is rendered correctly

Scenario: UI verfication of HelpdeskGeneral, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then HelpdeskGeneral page of helpdesk tab is rendered correctly

Scenario: UI verfication of HelpDeskReports, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then HelpDeskReports page of helpdesk tab is rendered correctly

Scenario: UI verfication of ServiceCode, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then ServiceCode page of helpdesk tab is rendered correctly

Scenario: UI verfication of ServiceRequest, helpdesk tab
Given user is logged in institution
When user is at the home tab
Then ServiceRequest page of helpdesk tab is rendered correctly
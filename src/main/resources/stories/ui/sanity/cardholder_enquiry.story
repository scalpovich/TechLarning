Smoke Testing of cardholder portal enquiry tab

Narrative:
In order to verify that all pages of cardholder portal enquiry tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CardHolderSmoke

Scenario: UI verfication of Transactions, Enquiry tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Transactions page of enquiry tab is rendered correctly

Scenario: UI verfication of CashRemittances, Enquiry tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CashRemittances page of enquiry tab is rendered correctly

Scenario: UI verfication of ViewCharges, Enquiry tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ViewCharges page of enquiry tab is rendered correctly
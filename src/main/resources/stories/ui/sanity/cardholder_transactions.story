Smoke Testing of cardholder portal transactions tab

Narrative:
In order to verify that all pages of cardholder portal transactions tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CardHolderSmoke

Scenario: UI verfication of CancelRemittanceBooking, transactions tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CancelRemittanceBooking page of transactions tab is rendered correctly

Scenario: UI verfication of CashRemittanceBooking, transactions tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CashRemittanceBooking page of transactions tab is rendered correctly

Scenario: UI verfication of FundTransfer, transactions tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then FundTransfer page of transactions tab is rendered correctly
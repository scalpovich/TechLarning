Narrative:
In order to verify that all pages of cardholder portal transactions tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CardHolderBV

Scenario: UI verification - Cardholder Portal -  Home Page, transactions tab
Meta:
@TestId TC378320
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Home page of transactions tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  CancelRemittanceBooking, transactions tab
Meta:
@TestId TC378317
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CancelRemittanceBooking page of transactions tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  CashRemittanceBooking, transactions tab
Meta:
@TestId TC378318
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CashRemittanceBooking page of transactions tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  FundTransfer, transactions tab
Meta:
@TestId TC378319
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then FundTransfer page of transactions tab is rendered correctly
And user signs out from cardholder portal
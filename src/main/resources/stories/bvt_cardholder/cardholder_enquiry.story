Narrative:
In order to verify that all pages of cardholder portal enquiry tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CardHolderBV

Scenario: UI verification - Cardholder Portal -  Home Page, Enquiry tab
Meta:
@TestId TC378307
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Home page of enquiry tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  Transactions, Enquiry tab
Meta:
@TestId TC378308
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Transactions page of enquiry tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  CashRemittances, Enquiry tab
Meta:
@TestId TC378306
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then CashRemittances page of enquiry tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  ViewCharges, Enquiry tab
Meta:
@TestId TC378309
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ViewCharges page of enquiry tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  Card Holder Home Page
Meta:
@TestId TC378305
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Card Holder Home page is rendered correctly
And user signs out from cardholder portal
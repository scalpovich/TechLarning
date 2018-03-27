Narrative:
In order to verify that all pages of cardholder portal virtualcard tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CardHolderBV

Scenario: UI verification - Cardholder Portal -  Home Page, virtualcard tab
Meta:
@TestId TC378323
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then Home page of virtualcard tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  RequestForLimitedValidityVirtualCard, virtualcard tab
Meta:
@TestId TC378321
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then RequestForLimitedValidityVirtualCard page of virtualcard tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  VirtualCardDetails, virtualcard tab
Meta:
@TestId TC378322
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualCardDetails page of virtualcard tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  VirtualCardLimitedValidityVirtualCardCancellation, virtualcard tab
Meta:
@TestId TC378324
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualCardLimitedValidityVirtualCardCancellation page of virtualcard tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  VirtualPrepaidCardRequest, virtualcard tab
Meta:
@TestId TC378325
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualPrepaidCardRequest page of virtualcard tab is rendered correctly
And user signs out from cardholder portal
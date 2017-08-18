Smoke Testing of cardholder portal virtualcard tab

Narrative:
In order to verify that all pages of cardholder portal virtualcard tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CardHolderSmoke

Scenario: UI verfication of RequestForLimitedValidityVirtualCard, virtualcard tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then RequestForLimitedValidityVirtualCard page of virtualcard tab is rendered correctly

Scenario: UI verfication of VirtualCardDetails, virtualcard tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualCardDetails page of virtualcard tab is rendered correctly

Scenario: UI verfication of VirtualCardLimitedValidityVirtualCardCancellation, virtualcard tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualCardLimitedValidityVirtualCardCancellation page of virtualcard tab is rendered correctly

Scenario: UI verfication of VirtualPrepaidCardRequest, virtualcard tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then VirtualPrepaidCardRequest page of virtualcard tab is rendered correctly
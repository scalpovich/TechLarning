Smoke Testing of cardholder portal services tab

Narrative:
In order to verify that all pages of cardholder portal services tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CardHolderSmoke

Scenario: UI verfication of ActivateDeactivateWallet, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ActivateDeactivateWallet page of services tab is rendered correctly

Scenario: UI verfication of ActivatePairedDevice, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ActivatePairedDevice page of services tab is rendered correctly

Scenario: UI verfication of BlockDevice, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then BlockDevice page of services tab is rendered correctly

Scenario: UI verfication of ECommActivation, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ECommActivation page of services tab is rendered correctly

Scenario: UI verfication of InternationalUseActivation, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then InternationalUseActivation page of services tab is rendered correctly

Scenario: UI verfication of ReplaceDevice, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ReplaceDevice page of services tab is rendered correctly

Scenario: UI verfication of UnblockDevice, services tab
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then UnblockDevice page of services tab is rendered correctly
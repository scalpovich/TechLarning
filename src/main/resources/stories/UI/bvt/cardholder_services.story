Narrative:
In order to verify that all pages of cardholder portal services tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CardHolderBV

Scenario: UI verification - Cardholder Portal -  ActivateDeactivateWallet, services tab
Meta:
@TestId TC378310
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ActivateDeactivateWallet page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  ActivatePairedDevice, services tab
Meta:
@TestId TC378311
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ActivatePairedDevice page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  BlockDevice, services tab
Meta:
@TestId TC378312
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then BlockDevice page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  ECommActivation, services tab
Meta:
@TestId TC378313
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ECommActivation page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  InternationalUseActivation, services tab
Meta:
@TestId TC378314
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then InternationalUseActivation page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  ReplaceDevice, services tab
Meta:
@TestId TC378315
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
Then ReplaceDevice page of services tab is rendered correctly
And user signs out from cardholder portal

Scenario: UI verification - Cardholder Portal -  UnblockDevice, services tab
Meta:
@TestId TC378316
Given user is on login page of cardholder portal
And user logs in with valid credentials
When user is logged into cardholder portal successfully
And user blocks the device from cardholder portal
Then UnblockDevice page of services tab is rendered correctly
When user unblocks the device from cardholder portal
Then user signs out from cardholder portal
Smoke Testing of cardholder portal all tabs

Narrative:
In order to verify that all pages of cardholder portal all tabs
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest

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
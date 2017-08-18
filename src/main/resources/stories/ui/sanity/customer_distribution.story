Smoke Testing of customer portal distribution tab

Narrative:
In order to verify that all pages of customer portal distribution tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CustomerSmoke

Scenario: UI verfication of AcceptanceOfReturnedInventory, distribution tab
Given user is logged in institution
When user is at the home tab
Then AcceptanceOfReturnedInventory page of distribution tab is rendered correctly

Scenario: UI verfication of ActivityReports, distribution tab
Given user is logged in institution
When user is at the home tab
Then ActivityReports page of distribution tab is rendered correctly

Scenario: UI verfication of CourierMaster, distribution tab
Given user is logged in institution
When user is at the home tab
Then CourierMaster page of distribution tab is rendered correctly

Scenario: UI verfication of Dispatch, distribution tab
Given user is logged in institution
When user is at the home tab
Then Dispatch page of distribution tab is rendered correctly

Scenario: UI verfication of DistributionOrderCancellation, distribution tab
Given user is logged in institution
When user is at the home tab
Then DistributionOrderCancellation page of distribution tab is rendered correctly

Scenario: UI verfication of InterestMaster, distribution tab
Given user is logged in institution
When user is at the home tab
Then InterestMaster page of distribution tab is rendered correctly

Scenario: UI verfication of SettlementConfirmation, distribution tab
Given user is logged in institution
When user is at the home tab
Then SettlementConfirmation page of distribution tab is rendered correctly
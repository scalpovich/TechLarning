Narrative:
In order to verify that all pages of customer portal distribution tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@CustomerBV

Scenario: UI verification - Customer Portal -  AcceptanceOfReturnedInventory, distribution tab
Meta:
@TestId TC379140
Given user is logged in institution
When user is at the home tab
Then AcceptanceOfReturnedInventory page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  ActivityReports, distribution tab
Meta:
@TestId TC379141
Given user is logged in institution
When user is at the home tab
Then ActivityReports page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  CourierMaster, distribution tab
Meta:
@TestId TC379142
Given user is logged in institution
When user is at the home tab
Then CourierMaster page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  Dispatch, distribution tab
Meta:
@TestId TC379143
Given user is logged in institution
When user is at the home tab
Then Dispatch page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  DistributionOrderCancellation, distribution tab
Meta:
@TestId TC379144
Given user is logged in institution
When user is at the home tab
Then DistributionOrderCancellation page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  InterestMaster, distribution tab
Meta:
@TestId TC379145
Given user is logged in institution
When user is at the home tab
Then InterestMaster page of distribution tab is rendered correctly
And user signs out from customer portal

Scenario: UI verification - Customer Portal -  SettlementConfirmation, distribution tab
Meta:
@TestId TC379146
Given user is logged in institution
When user is at the home tab
Then SettlementConfirmation page of distribution tab is rendered correctly
And user signs out from customer portal
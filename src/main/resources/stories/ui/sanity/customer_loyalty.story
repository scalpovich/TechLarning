Smoke Testing of customer portal loyalty tab

Narrative:
In order to verify that all pages of customer portal loyalty tab
As a user
I want to assert pages

Meta:
@StoryName S224290
@SmokeTest
@CustomerSmoke

Scenario: UI verfication of EventBasedLoyaltyPoints, loyalty tab
Given user is logged in institution
When user is at the home tab
Then EventBasedLoyaltyPoints page of loyalty tab is rendered correctly

Scenario: UI verfication of EventBasedLoyaltyPointsPosting, loyalty tab
Given user is logged in institution
When user is at the home tab
Then EventBasedLoyaltyPointsPosting page of loyalty tab is rendered correctly

Scenario: UI verfication of GiftRewardCatalogue, loyalty tab
Given user is logged in institution
When user is at the home tab
Then GiftRewardCatalogue page of loyalty tab is rendered correctly

Scenario: UI verfication of LoyaltyPlan, loyalty tab
Given user is logged in institution
When user is at the home tab
Then LoyaltyPlan page of loyalty tab is rendered correctly

Scenario: UI verfication of LoyaltyPlanPromotionMapping, loyalty tab
Given user is logged in institution
When user is at the home tab
Then LoyaltyPlanPromotionMapping page of loyalty tab is rendered correctly

Scenario: UI verfication of LoyaltyPoints, loyalty tab
Given user is logged in institution
When user is at the home tab
Then LoyaltyPoints page of loyalty tab is rendered correctly

Scenario: UI verfication of LoyaltyTransactionPlan, loyalty tab
Given user is logged in institution
When user is at the home tab
Then LoyaltyTransactionPlan page of loyalty tab is rendered correctly

Scenario: UI verfication of PromotionPlan, loyalty tab
Given user is logged in institution
When user is at the home tab
Then PromotionPlan page of loyalty tab is rendered correctly

Scenario: UI verfication of Redemption, loyalty tab
Given user is logged in institution
When user is at the home tab
Then Redemption page of loyalty tab is rendered correctly

Scenario: UI verfication of RewardRedemption, loyalty tab
Given user is logged in institution
When user is at the home tab
Then RewardRedemption page of loyalty tab is rendered correctly
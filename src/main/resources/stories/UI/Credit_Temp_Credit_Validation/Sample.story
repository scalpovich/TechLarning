Narrative:
As a Customer portal user
I want to validate permanent credit limit for retail card
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can validate credit transaction limit for retail card
Given setting json values in excel for Credit
Given user is logged in institution
When User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user activates permanent credit limit change request
And user verify available Card limit for card after transaction
Then user sign out from customer portal
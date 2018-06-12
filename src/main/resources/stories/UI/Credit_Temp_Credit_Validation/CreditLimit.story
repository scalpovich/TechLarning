!-- @author: E080534
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
@CardReplacementCredit

Scenario:To Verify that the user can validate credit transaction limit
Given setting json values in excel
Given user is logged in institution
When User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user activates credit limit change request

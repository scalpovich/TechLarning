!-- @author: E080534
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail

Scenario: CreditLimit
Given setting json values in excel
And user is logged in institution
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user activates credit limit change request
Then device has "normal" status
Then user verify available Card limit for card after transaction
And user sign out from customer portal
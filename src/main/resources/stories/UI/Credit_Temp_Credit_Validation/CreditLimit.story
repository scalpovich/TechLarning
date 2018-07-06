!-- @author: E080534
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail

Scenario: CreditLimit
Given setting json values in excel
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then user verify available balance after transaction
Then device has "normal" status
Then user verify available Card limit for card after transaction
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user verify temproary credit client limit
And user sign out from customer portal
!-- @author: E080534
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail
Scenario: CreditLimit
And user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
Then available balance is updated in current status and limits tab
And user sign out from customer portal
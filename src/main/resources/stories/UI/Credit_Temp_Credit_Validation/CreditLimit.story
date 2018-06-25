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

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
When MAS simulator is closed
And user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
Then available balance is updated in current status and limits tab
And user sign out from customer portal
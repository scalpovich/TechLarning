!-- @author: E080534
Narrative:
As a Customer portal user
I want to validate temproary credit limit  
so that credit limit should be validated

Meta:
@StoryName credit_emv_retail

Scenario: CreditLimit
Given setting json values in excel
Given user is logged in institution
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user activates credit limit change request
Then device has "normal" status
Then user verify available Card limit for card after transaction
And user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user verify temproary credit client limit
And user sign out from customer portal

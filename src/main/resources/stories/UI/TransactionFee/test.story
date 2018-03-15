Meta:
@StoryName p_emv_retail_travel

Scenario: Perform EMV_PURCHASE Authorization transaction
Given user is logged in institution
When verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal
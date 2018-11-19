Narrative:
In order to validate Device Promotion Plan Priority
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail_Limits
@Ashu_test_test

Scenario: 1.5 Perform EMV_PURCHASE Authorization transaction
When user is logged in institution
Then validate auth report
And user sign out from customer portal
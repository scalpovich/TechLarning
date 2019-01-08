Narrative:
In order to validate surcharge amount on transaction
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail
@Surchage
@TEST_TEST_TEST

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
And user get data from excel for SurchargeWithSystemCalculatedPlan scenario and Credit product
When user is logged in institution
When user verify "normal" status and note down device details for with pin card
And user creates MID TID Blocking for combination 1
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When User set MID_TID flag true and MID_TID Combination 1
And perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal
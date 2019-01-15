Narrative:
In order to validate purchase funcationality
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail
@excelDriven


Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
And user gets data from excel for General scenario and Credit product
When user is logged in institution
And user verifies "normal" status and note down device details for with pin card
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal
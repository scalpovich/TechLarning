Narrative:
In order to recurring functionality
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail
@excelDriven

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
And user gets data from excel for GeneralMSR scenario and Credit product
When user is logged in institution
And user verify "normal" status and note down device details for without pin card
Then user sign out from customer portal

Scenario: 1.2 Perform RECURRING_PUR_TXN Authorization transaction
Given connection to MAS is established
When perform an MSR_RECURRING_PUR_TXN MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal
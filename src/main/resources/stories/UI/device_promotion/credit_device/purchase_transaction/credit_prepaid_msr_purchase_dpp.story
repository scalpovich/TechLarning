Narrative:
In order to check purcase transactions on prepaid EMV corporate card
As an issuer
I want to authorize transactions with devie promotion plan

Meta:
@creditDevicePromotion
@StoryName transactionWithDevicePromotionPlan

Scenario:Create prepaid EMV card
Given setting json values in excel for Credit
When user is logged in institution
And device range for program with device plan for "prepaid" "msr" card
And user creates new device of prepaid type for new client
Then device has "normal" status
And user performs adjustment transaction
And user sign out from customer portal

Scenario:Perform Purchase transaction with existing device Plan and verify the transaction
Given connection to MAS is established
And perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:Perform purcase transaction with updated device promotion plan
Given user is logged in institution
And update prepaid device with promotion plan
And connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal
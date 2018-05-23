Narrative:
In order to achieve something
As a user
I want to create surcharge plan
So that initial data setup is ready

Meta:
@CreditRegression
@MCGLimitPlan
@Author Nitin Kumar
@StoryName MCG_LIMIT

Scenario: Set up prepaid emv retail general purpose card with MCG Limit Plan
Given user is logged in institution
And user creates MCG with MCC
And user creates MCG limit plan with details for Prepaid
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid EMV retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal
Then embossing file batch was generated in correct format

Scenario: Perform ASI_EMV-RetailGeneralPurposeCard Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then verify the MCG Limit in Device Usage Screen


!-- @author: E076170
Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a Prepaid device  
so that the user's device range can be stoplisted and stoplist withdrawal

Meta:
@StoryName prepaid_msr_retail_gift_stoplist_withdraw
@CardStoplistAndWithdrawal

Scenario: Set up prepaid msr retail gift card authorization pinless
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card without pin
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
When embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:To Verify that the user can stoplist device range of prepaid card
Given user is logged in institution
When user stoplists a device range from stoplist device range screen
When user stoplists a device range from stoplist device range screen
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid card after stoplisted device range
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Given user is logged in institution
Then search Pre-Auth authorization and verify 207-PICK-UP CARD status
Then assert Capture response with 27001 AuthDecline Code and Device range is stoplisted. as description
Then user sign out from customer portal

Scenario:To Verify that the user can withdraw stoplist device range of prepaid card
Given user is logged in institution
When user withdraws a device range from withdraw device range screen
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction on prepaid card after withdrawn device range
When perform an MSR_PREAUTH MAS transaction on the same card
Then MAS test results are verified
Then MAS simulator is closed
Given user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
Then user sign out from customer portal
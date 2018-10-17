Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate prepaid card to check differenr status Refer/Capture.

Meta:
@StoryName p_emv_corp_travel				 

Scenario:1.1 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "prepaid" "emv" card for issuer scripting
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario:1.2 When User Change device status to Capture of Lost Status
Given user is logged in institution
When User Changes Device Status to Capture [3]
And user stoplists a card from stoplist device screen
And user sign out from customer portal

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Capture authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.4 When User Chnage device status to Refer of Lost Status
Given user is logged in institution
When User Changes Device Status to Refer [2]
And user stoplists a card from stoplist device screen
Then user sign out from customer portal

Scenario:1.5 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Refer authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed
Narrative:
In order to test MID TID blocking rule
As a issuer
I want to perform Transaction

Meta:
@StoryName prepaid_emv_retail_Limits

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
Then user sign out from customer portal

Scenario: 1.2 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 1
Then user sign out from customer portal

Scenario: 1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When User set MID_TID flag true and MID_TID Combination 1
And perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.5 Verify Decline Code on Helpdesk Page
Given user is logged in institution
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product prepaid
And user sign out from customer portal

Scenario: 1.6 Delete First Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 1
And user sign out from customer portal

Scenario: 1.7 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.8 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 2
Then user sign out from customer portal

Scenario: 1.9 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 2
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.0 Verify Decline Code on Helpdesk Page
Given user is logged in institution
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product prepaid
And user sign out from customer portal

Scenario: 2.1 Delete Second Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 2
And user sign out from customer portal

Scenario: 2.2 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.3 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 3
Then user sign out from customer portal

Scenario: 2.4 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 3
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.5 Verify Decline Code on Helpdesk Page
Given user is logged in institution
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product prepaid
And user sign out from customer portal

Scenario: 2.6 Delete Third Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 3
And user sign out from customer portal

Scenario: 2.7 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.8 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 4
Then user sign out from customer portal

Scenario: 2.9 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 4
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 3.0 Verify Decline Code on Helpdesk Page
Given user is logged in institution
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product prepaid
And user sign out from customer portal

Scenario: 3.1 Delete Fourth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 4
And user sign out from customer portal

Scenario: 3.2 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed
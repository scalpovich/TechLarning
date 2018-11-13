Narrative:
In order to test MID TID blocking rule
As a issuer
I want to perform Transaction

Meta:
@StoryName d_emv_corp
@mid_tid_debit

Scenario: 1.0 Set up program for debit EMV corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "emv" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: 1.1 debit EMV corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "NOT ACTIVATED CARD" status
Then user activates device through helpdesk
And device has "normal" status
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: 1.2 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 1
Then user sign out from customer portal

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
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Debit
Then user sign out from customer portal

Scenario: 1.6 Delete First Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 1
Then user sign out from customer portal

Scenario: 1.7 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
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
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Debit
Then user sign out from customer portal

Scenario: 2.1 Delete Second Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 2
Then user sign out from customer portal

Scenario: 2.2 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
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
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Debit
Then user sign out from customer portal

Scenario: 2.6 Delete Third Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 3
Then user sign out from customer portal

Scenario: 2.7 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
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
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Debit
Then user sign out from customer portal

Scenario: 3.1 Delete Fourth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 4
Then user sign out from customer portal

Scenario: 3.2 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed
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
And user get data from excel for Test scenario
And user is logged in institution
When user creates MID TID Blocking for combination 1
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

Scenario: 1.4 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 1.5 Delete First Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 1
Then user sign out from customer portal

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.7 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 2
Then user sign out from customer portal

Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 2
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.9 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 2.0 Delete Second Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 2
Then user sign out from customer portal

Scenario: 2.1 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.2 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 3
Then user sign out from customer portal

Scenario: 2.3 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 3
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.4 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 2.5 Delete Third Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 3
Then user sign out from customer portal

Scenario: 2.6 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.7 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 4
Then user sign out from customer portal

Scenario: 2.8 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 4
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.9 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 3.0 Delete Fourth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 4
Then user sign out from customer portal

Scenario: 3.1 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.1 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 5
Then user sign out from customer portal

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
When User set MID_TID flag true and MID_TID Combination 5
And perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.4 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 1.5 Delete Fifth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 5
Then user sign out from customer portal

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.7 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 7
Then user sign out from customer portal

Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 7
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.9 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 2.0 Delete Seventh Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 7
Then user sign out from customer portal

Scenario: 2.1 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.2 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 8
Then user sign out from customer portal

Scenario: 2.3 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 8
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.4 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 2.5 Delete Eight Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 8
Then user sign out from customer portal

Scenario: 2.6 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 2.7 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 9
Then user sign out from customer portal

Scenario: 2.8 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 9
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 2.9 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 3.0 Delete Ninth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 9
Then user sign out from customer portal

Scenario: 3.1 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.1 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 10
Then user sign out from customer portal

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
When User set MID_TID flag true and MID_TID Combination 10
And perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.4 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 1.5 Delete Tenth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 10
Then user sign out from customer portal

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.7 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 11
Then user sign out from customer portal

Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction
Given User set MID_TID flag true and MID_TID Combination 11
When perform an EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal

Scenario: 1.9 Verify Decline Code on Helpdesk Page
Given user is logged in institution
When verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
Then user sign out from customer portal

Scenario: 2.0 Delete Eleventh Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 11
Then user sign out from customer portal

Scenario: 2.1 Perform EMV_PURCHASE Authorization transaction
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed
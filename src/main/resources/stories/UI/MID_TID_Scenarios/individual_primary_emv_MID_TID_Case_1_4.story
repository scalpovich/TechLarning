Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on Retails credit card.

Meta:
@StoryName credit_emv_retail

Scenario: 1.0 Creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario: 1.1 Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 1
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
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
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
And user sign out from customer portal

Scenario: 1.5 Delete First Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 1
And user sign out from customer portal

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
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
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
And user sign out from customer portal

Scenario: 2.0 Delete Second Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 2
And user sign out from customer portal

Scenario: 2.1 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
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
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
And user sign out from customer portal

Scenario: 2.5 Delete Third Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 3
And user sign out from customer portal

Scenario: 2.6 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
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
Then verify Decline code for Transaction MID-TID Blocked on helpdesk page for product Credit
And user sign out from customer portal

Scenario: 3.0 Delete Fourth Combination of MID_TID Blocking rule
Given user is logged in institution
When user deletes MID TID Blocking for Combination 4
And user sign out from customer portal

Scenario: 3.1 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed
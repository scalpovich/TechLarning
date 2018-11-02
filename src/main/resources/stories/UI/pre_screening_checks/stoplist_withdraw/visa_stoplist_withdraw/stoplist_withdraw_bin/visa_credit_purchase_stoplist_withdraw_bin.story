Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a credit device bin 
so that the user's device bin can be stoplisted and stoplist withdrawal

Meta:
@StoryName visa_credit_stoplist_withdrawal

Scenario:1.1 Set up retail credit card
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills Device Plan for credit product for Visa
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario:1.2 To Verify that the user can stoplist device bin of credit device
Given user is logged in institution
When user stoplists a device bin from stoplist device bin screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
Then PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.4 Transaction - Purchase Completion transaction after stoplist bin
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 207-PICK-UP CARD status
And assert Capture response with 27002 AuthDecline Code and Bin is stoplisted. as description
And user sign out from customer portal

Scenario:1.5 To Verify that the user can withdraw stoplist device bin of credit device
Given user is logged in institution
When user withdraws a device Bin from withdraw device Bin screen
Then user sign out from customer portal

Scenario:1.6 Transaction - Purchase Completion transaction after withdraw bin
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then VISA simulator is closed
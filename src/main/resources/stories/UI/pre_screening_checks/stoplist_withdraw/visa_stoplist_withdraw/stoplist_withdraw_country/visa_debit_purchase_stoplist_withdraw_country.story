Narrative:
As a Customer portal user
I want to stoplist and stoplist withdraw a debit device country 
so that the user's device country can be stoplisted and stoplist withdrawal

Meta:
@StoryName visa_credit_stoplist_withdrawal

Scenario: 1.1 Set up retail debit card
Given setting json values in excel for Debit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for debit product for Visa
And User fills Wallet Plan for debit product and program Retail Debit Card [11]
And User Primary Device fills New Program Retail Debit Card section for debit product for Visa
And for Primary Device and New Client user fills Device Range section for debit product
And debit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card [1]
And debit processes pre-production batch using new Device
And debit processes deviceproduction batch using new Device for Supplementary
And debit processes pinProduction batch using new Device for Supplementary
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then device has "normal" status
And user sign out from customer portal

Scenario:1.2 To Verify that the user can stoplist country of debit device
Given user is logged in institution
When user stoplists a country from stoplist country screen
And user edits deviceplan and enables stoplist flag
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
Then PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.4 Transaction - Purchase Completion transaction after stoplist country
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 27003 AuthDecline Code and Country is stoplisted. as description
And user sign out from customer portal

Scenario:1.5 To Verify that the user can withdraw stoplist country of debit device
Given user is logged in institution
When user withdraws a country from withdraw country screen
Then user sign out from customer portal

Scenario:1.6 Transaction - Purchase Completion transaction after withdraw country
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And VISA simulator is closed
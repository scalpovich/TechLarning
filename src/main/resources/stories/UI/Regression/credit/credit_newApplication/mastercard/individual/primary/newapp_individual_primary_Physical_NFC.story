Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert card creation

Meta:
@StoryName credit_card
				 
Scenario:creation of mastercard_individual_primary_Physical NFC Device Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for NFC Device - Paypass User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Device Range section for credit product
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and NFC Device - Paypass
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL
And user sign out from customer portal
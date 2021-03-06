Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert card creation


Meta:
@StoryName credit_card
		 
Scenario:creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for credit product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Plan for credit product and program Retail General Purpose Card [4]
And User Add-on Device fills Existing Program Retail General Purpose Card [4] section for credit product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for credit product
And for Add-on Device and Existing Client user fills Device Range section for credit product
And credit device is created using new Application screen for Individual [0] and "Primary Device [P]" and New Client [N] and Magnetic Stripe Card [1]
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

Scenario:Board new add-on device
Given user is logged in institution
When credit device is created using new Application screen for Individual [0] and "Add-on Device [A]" and New Client [N] and EMV Card [2]
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
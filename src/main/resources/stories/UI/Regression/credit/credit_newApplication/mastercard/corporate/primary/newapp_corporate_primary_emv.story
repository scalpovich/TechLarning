Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert card creation

Meta:
@StoryName credit_card	
@RegressionGroup
		 
Scenario:creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Corporate Credit Card [10]
And User Primary fills new Program Corporate Credit Card [10] section for credit product for mastercard
And User fills Device Range section for credit product
And credit device is created using new Application screen for Corporate [1] and "Primary Device" and New Client and EMV Card
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
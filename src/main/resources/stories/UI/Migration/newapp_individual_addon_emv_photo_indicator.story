Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to create Add-On photo card

Meta:
@StoryName credit_card	 
Scenario:verify that the Add-on photo indicator should be available in Credit Screen
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for credit product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Plan for credit product and program Retail Credit Card [9]
And User Add-on Device fills new Program Retail Credit Card [9] section for credit product for MASTERCARD [02]
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
And User search for new application on search screen for credit and validates the status as NORMAL
And credit device is created using new Application screen for Individual [0] and "Add-on Device [A]" and New Client [N] and EMV Card [2]
And user checks in Incomplete Application for the credit application device
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll riskAnalysis batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processesAll creditBureauVerification batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL
And user sign out from customer portal
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to  board More than one applications are associated with single batch number


Meta:
@StoryName credit_card	 
Scenario: verify that after applications send to Pushback and current batch is closed then incomplete applications moves to subsequent batch
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Plan for credit product and program Retail Credit Card [9]
And User Primary fills new Program Retail Credit Card section for credit product for MASTERCARD [02]
And User fills Device Range section for credit product
And credit device is created using new Application screen for Individual [0] and "Primary Device [P]" and New Client [N] and Magnetic Stripe Card [1]
And user verifies the credit application device
When user pushback the credit application device
And credit device is created with open batch using new Application screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And User search for new application on search screen for credit and validates the status as NORMAL
And user sign out from customer portal


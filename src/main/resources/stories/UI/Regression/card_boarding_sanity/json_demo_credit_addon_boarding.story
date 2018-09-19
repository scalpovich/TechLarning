Narrative:
As a user
I want to login into customer portal 
In order to create add-on credit card


Meta:
@StoryName credit_card
@PrepaidRegression

Scenario: To verify functionality addon of emv credit card boarding
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for credit product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Plan for credit product and program Retail Credit Card [9]
And User Add-on Device fills Existing Program Retail Credit Card [9] section for credit product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for credit product
And for Add-on Device and Existing Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And credit device is created using new device screen for Individual [0] and Add-on Device [A] and New Client [N] and EMV Card [2]
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal
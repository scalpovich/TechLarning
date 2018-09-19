Narrative:
As a user
I want to login into customer portal 
In order to create add-on debit card


Meta:
@StoryName debit_card
@PrepaidRegression

Scenario: To verify functionality addon of emv debit card boarding
Given setting json values in excel for Debit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for debit product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for debit product for MASTERCARD [02]
And User fills Wallet Plan for debit product and program Corporate General Purpose Card [8]
And User Add-on Device fills Existing Program Corporate General Purpose Card [8] section for debit product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for debit product
And for Add-on Device and Existing Client user fills Device Range section for debit product
And debit device is created using new device screen for Corporate [1] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And debit processes pre-production batch using new Device
And debit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for debit and validates the status as NORMAL
And debit device is created using new device screen for Corporate [1] and Add-on Device [A] and New Client [N] and EMV Card [2]
And debit processes pre-production batch using new Device
And debit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for debit and validates the status as NORMAL
And user sign out from customer portal
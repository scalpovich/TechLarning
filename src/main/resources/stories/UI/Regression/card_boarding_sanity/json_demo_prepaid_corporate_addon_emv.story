Narrative:
As a user
I want to login into customer portal 
In order to create add-on prepaid card


Meta:
@StoryName prepaid_card
@PrepaidRegression

Scenario: To verify functionality addon of emv prepaid card boarding
Given setting json values in excel for Prepaid
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for prepaid product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Plan for prepaid product and program Corporate General Purpose Card [8]
And User Add-on Device fills Existing Program Corporate General Purpose Card [8] section for prepaid product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for prepaid product
And for Add-on Device and Existing Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Corporate [1] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
And prepaid device is created using new device screen for Corporate [1] and Add-on Device [A] and New Client [N] and EMV Card [2]
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
And user sign out from customer portal
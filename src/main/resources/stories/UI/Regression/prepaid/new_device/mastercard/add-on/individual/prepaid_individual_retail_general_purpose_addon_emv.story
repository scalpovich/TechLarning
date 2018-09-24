Narrative:
As a user
I want to login into customer portal 
In order to create add-on prepaid card


Meta:
@StoryName prepaid_card

Scenario: To verify functionality of add-on prepaid card boarding
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Statement Message Plan for prepaid product
And User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And User fills MCC Rules for prepaid product
And User fills Dedupe Plan
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And for Magnetic Stripe Card [1] User fills Device Plan for prepaid product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User Add-on Device fills Existing Program Retail General Purpose Card [4] section for prepaid product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for prepaid product
And for Add-on Device and Existing Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And prepaid device is created using new device screen for Individual [0] and Add-on Device [A] and New Client [N] and EMV Card [2]
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
And user sign out from customer portal
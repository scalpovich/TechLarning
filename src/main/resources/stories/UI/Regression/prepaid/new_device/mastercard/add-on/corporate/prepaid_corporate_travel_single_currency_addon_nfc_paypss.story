!-- auther: e076168
Narrative:
As a Cardhodler
I want to able to loing into customer portal 
In order to crate prepaid card


Meta:
@StoryName prepaid_card
@SanityCards

Scenario: To verify functionality of prepaid card boarding
Given setting json values in excel
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
When User fills Marketing Message Plan for prepaid product
When User fills Prepaid Statement Plan
When User fills MCC Rules for prepaid product
And User fills Dedupe Plan
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And for Magnetic Stripe Card [1] User fills Device Plan for prepaid product for MASTERCARD [02]
And for Physical NFC Device - Paypass [5] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Plan for prepaid product and program Corporate Travel Card - Single Currency [5]
And User Add-on Device fills Existing Program Corporate Travel Card - Single Currency [5] section for prepaid product for MASTERCARD [02]
When for Primary Device and New Client user fills Device Range section for prepaid product
When for Add-on Device and Existing Client user fills Device Range section for prepaid product
Then prepaid device is created using new device screen for Corporate [1] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
Then prepaid device is created using new device screen for Corporate [1] and Add-on Device [A] and New Client [N] and Physical NFC Device - Paypass [5]
Then prepaid processes pre-production batch using new Device
Then prepaid processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
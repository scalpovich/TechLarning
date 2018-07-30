!-- auther: e076168
Narrative:
As a Cardhodler
I want to loing into customer portal 
In order to create prepaid card


Meta:
@StoryName prepaid_card
@SanityCards

Scenario: To verify functionality of prepaid card boarding
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
And for EMV Card [2] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User Supplementary Device fills Existing Program Retail General Purpose Card [4] section for prepaid product for MASTERCARD [02]
And User fills Business Mandatory Fields Screen for prepaid product
When for Primary Device and New Client user fills Device Range section for prepaid product
When for Supplementary Device and Existing Client user fills Device Range section for prepaid product
Then prepaid device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
Then prepaid device is created using new device screen for Individual [0] and Supplementary Device [S] and Existing Program [E] and EMV Card [2]
Then prepaid processes pre-production batch using new Device
Then prepaid processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
!-- author: e076168
Narrative:
As a user
I want to login into customer portal 
In order to create add-on debit card


Meta:
@StoryName debit_card
@SanityCards

Scenario: To verify functionality of prepaid card boarding
Given setting json values in excel
When user is logged in institution
And User fills MCC Rules for debit product
And User fills Dedupe Plan
And User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And for Magnetic Stripe Card [1] User fills Device Plan for debit product for MASTERCARD [02]
And for Physical NFC Device - Mag Stripe Paypass [3] User fills Supplementary Device Plan for debit product for MASTERCARD [02]
And User fills Wallet Plan for debit product and program Retail Debit Card [11]
And User Add-on Device fills Existing Program Retail Debit Card [11] section for debit product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for debit product
And for Add-on Device and Existing Client user fills Device Range section for debit product
And debit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And debit device is created using new device screen for Individual [0] and Add-on Device [A] and New Client [N] and Physical NFC Device - Mag Stripe Paypass [3]
And debit processes pre-production batch using new Device
And debit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for debit and validates the status as NORMAL
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
When User fills MCC Rules for debit product
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
When for Primary Device and New Client user fills Device Range section for debit product
When for Add-on Device and Existing Client user fills Device Range section for debit product
Then debit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
Then debit device is created using new device screen for Individual [0] and Add-on Device [A] and Existing Client [E] and Physical NFC Device - Mag Stripe Paypass [3]
Then debit processes pre-production batch using new Device
Then debit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for debit and validates the status as NORMAL
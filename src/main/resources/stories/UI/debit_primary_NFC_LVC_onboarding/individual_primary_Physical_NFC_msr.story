Narrative:
In order to a create a Debit Physical NFC MSR Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@DebitRegression
@StoryName debit_emv_retail
@Individual				 
Scenario:creation of mastercard_individual_primary_Physical NFC Device - msr Paypass Card debit device
Meta:
@UserCreatesNewDebitDevice
Given setting json values in excel for Debit
When user is logged in institution
And User fills Dedupe Plan
And user creates a mark up fee plan and verify it
And User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And for NFC Device - Mag Stripe Paypass [3] User fills Device Plan for debit product for MASTERCARD [02]
And User fills Wallet Plan for debit product and program Retail Debit Card [11]
And User fills MCC Rules for debit product
And User Primary Device [P] fills New Client [N] Program Retail Debit Card [11] section for debit product for MASTERCARD [02]
And for Primary Device [P] and New Client [N] user fills Device Range section for debit product
Then debit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and NFC Device - Mag Stripe Paypass [3]
And debit processes pre-production batch using new Device
And debit processes deviceproduction batch using new Device for Supplementary
And debit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for debit and validates the status as NORMAL
And user sign out from customer portal
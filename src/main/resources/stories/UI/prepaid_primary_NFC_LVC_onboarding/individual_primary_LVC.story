Narrative:
In order to a create a Prepaid Primary LVC Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@prepaidRegression
@StoryName credit_emv_retail
@Individual				 
Scenario:creation of mastercard_individual_primary_LVC Card prepaid device
Meta:
@UserCreatesNewprepaidDevice
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for prepaid product
And User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And user creates a mark up fee plan and verify it
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And for Limited Validity Virtual Card [8] User fills Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User fills MCC Rules for prepaid product
And User Primary Device [P] fills New Client [N] Program Retail General Purpose Card [4] section for prepaid product for MASTERCARD [02]
When for Primary Device [P] and New Client [N] user fills Device Range section for prepaid product
Then prepaid device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Limited Validity Virtual Card [8]
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
And prepaid processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for prepaid and validates the status as NORMAL
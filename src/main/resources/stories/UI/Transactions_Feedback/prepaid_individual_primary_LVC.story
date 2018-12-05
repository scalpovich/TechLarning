Narrative:
In order to a create a Prepaid Primary LVC Device under customer portal cardmanagement tab
As a user
I want to assert PDF Details of LVC Prepaid card

Meta:
@StoryName prepaid_emv_retail			 
Scenario:1.1 creation of mastercard_individual_primary_LVC Card prepaid device
Given setting json values in excel for Prepaid
When user is logged in institution
And for Limited Validity Virtual Card [8] User fills Device Plan for prepaid product for MASTERCARD [02]
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User fills MCC Rules for prepaid product
And User Primary Device [P] fills New Client [N] Program Retail General Purpose Card [4] section for prepaid product for MASTERCARD [02]
And for Primary Device [P] and New Client [N] user fills Device Range section for prepaid product
Then prepaid device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Limited Validity Virtual Card [8]
And prepaid processes pre-production batch using new Device
And device has "NORMAL [0]" status
When user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario:1.2 Download PDF File for LVC Crad
Given User Downloads and Verify PDF File for LVC Card


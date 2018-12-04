Narrative:
In order to a create a Debit Primary LVC Device under customer portal cardmanagement tab
As a user
I want to assert PDF Details of LVC Debit card

Meta:
@prepaidRegression
@StoryName d_emv_corp
@Individual				 
Scenario:1.1 creation of mastercard_individual_primary_LVC Card prepaid device
Meta:
@UserCreatesNewprepaidDevice
Given setting json values in excel for Debit
When user is logged in institution
And for Limited Validity Virtual Card [8] User fills Device Plan for debit product for MASTERCARD [02]
And User fills Wallet Plan for debit product and program Retail Debit Card [11]
And User fills MCC Rules for debit product
And User Primary Device [P] fills New Client [N] Program Retail Debit Card [11] section for debit product for MASTERCARD [02]
And for Primary Device [P] and New Client [N] user fills Device Range section for debit product
Then debit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Limited Validity Virtual Card [8]
And debit processes pre-production batch using new Device
And device has "NORMAL [0]" status
And user activates device through helpdesk
When user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario:1.2 Download PDF File for LVC Crad
Given User Download and Verify PDF File for LVC Card


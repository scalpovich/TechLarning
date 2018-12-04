Narrative:
In order to a create a Credit Primary LVC Device under customer portal cardmanagement tab
As a user
I want to assert PDF Details of LVC Credit card

Meta:
@prepaidRegression
@StoryName credit_emv_retail
@Individual				 
Scenario:1.1 creation of mastercard_individual_primary_LVC Card prepaid device
Meta:
@UserCreatesNewprepaidDevice
Given setting json values in excel for Credit
When user is logged in institution
And for Limited Validity Virtual Card [8] User fills Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and Limited Validity Virtual Card [8]
And credit processes pre-production batch using new Device
And device has "normal" status
And user sign out from customer portal

Scenario:1.2 Download PDF File for LVC Crad
Given User Download and Verify PDF File for LVC Card
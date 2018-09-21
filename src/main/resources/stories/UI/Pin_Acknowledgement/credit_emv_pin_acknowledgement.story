credit emv pin acknowledgement Positive Scenario

Narrative:
In order to provide to client easy-to-use multi-purpose credit card with pin
As an issuer
I want to create EMV Credit card with pin and verify positive pin acknowledgement


Meta:
@StoryName credit_emv_retail_pin_ack
@TCName TC857949

Scenario: Set up credit emv retail general purpose card device production

Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And Pin Offset file batch was generated successfully
And Pin Offset file was updated with positive pin acknowledgement
And User uploads the PinOffset file and creates PIN Offset File Acknowledgement Upload batch file
Then user sign out from customer portal


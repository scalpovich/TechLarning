credit emv pin acknowledgement Negative Scenario

Narrative:
In order to provide to client easy-to-use general purpose credit card with pin
As an issuer
I want to create EMV Credit card with pin and verify negative pin acknowledgement


Meta:
@StoryName credit_emv_retail_pin_ack
@TCName TC857948

Scenario: 1. Set up credit emv retail general purpose card device production
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
Then user sign out from customer portal

Scenario: 2. Update pin offset file with negative pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When Pin Offset file was updated with negative pin acknowledgement
And User uploads the updated PinOffset file to Server
Then User deletes existing pin offset files

Scenario: 3. Process Batches and Resend Pin Request
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And credit processes resend pin request batch using new Device
And credit processes pingeneration batch using new Device for Supplementary
Then user sign out from customer portal

Scenario: 4. Update pin offset file with positive pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When User updates the new pin offset file with positive pin acknowledgement
Then User uploads the updated PinOffset file to Server

Scenario: 5. Process Batches and verify status of Carrier
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And user processes Send To Carrier batch for Pin File Type and product credit
And credit processes DOWNLOAD Carrier Download Batch batch for Pin File Type
And credit processes Carrier Acknowledgement batch for Pin File Type
And search with device in device tracking screen and status of carrier
Then user sign out from customer portal

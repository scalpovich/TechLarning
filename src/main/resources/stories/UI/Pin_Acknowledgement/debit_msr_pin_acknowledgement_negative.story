debit msr pin acknowledgement Negative Scenario

Narrative:
In order to provide to client easy-to-use general purpose debit card with pin
As an issuer
I want to create MSR debit card with pin and verify negative pin acknowledgement


Meta:
@StoryName d_msr_corp_pin_ack
@TCName TC857948

Scenario: 1. Set up program for debit MSR corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "magnetic stripe" card
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: 2. debit msr corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
Then user sign out from customer portal

Scenario: 3. Update pin offset file with negative pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When Pin Offset file was updated with negative pin acknowledgement
And User uploads the updated PinOffset file to Server
Then User deletes existing pin offset files

Scenario: 4. Process Batches and Resend Pin Request
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And debit processes resend pin request batch using new Device
And debit processes pingeneration batch using new Device for Supplementary
Then user sign out from customer portal

Scenario: 5. Update pin offset file with positive pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When User updates the new pin offset file with positive pin acknowledgement
Then User uploads the updated PinOffset file to Server

Scenario: 6. Process Batches and verify status of Carrier
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And user processes Send To Carrier batch for PIN File Type and product debit
And debit processes DOWNLOAD Carrier Download Batch batch for PIN File Type
And debit processes Carrier Acknowledgement batch for PIN File Type
And search with device in device tracking screen and status of carrier
Then user sign out from customer portal


prepaid emv pin acknowledgement negative Scenario

Narrative:
In order to provide to client easy-to-use general purpose prepaid card with pin
As an issuer
I want to create EMV prepaid card with pin and verify negative pin acknowledgement


Meta:
@StoryName p_emv_corp_travel_pin_ack
@TCName TC857948

Scenario: 1. Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: 2. prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user sign out from customer portal

Scenario: 3. Update pin offset file with negative pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When Pin Offset file was updated with negative pin acknowledgement
And User uploads the updated PinOffset file to Server
Then User deletes existing pin offset files

Scenario: 4. Process Batches and Resend Pin Request
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And prepaid processes resend pin request batch using new Device
And prepaid processes pingeneration batch using new Device for Supplementary
And user sign out from customer portal

Scenario: 5. Update pin offset file with positive pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When User updates the new pin offset file with positive pin acknowledgement
Then User uploads the updated PinOffset file to Server

Scenario: 6. Process Batches and verify status of Carrier
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And user processes Send To Carrier batch for PIN File Type and product prepaid
And prepaid processes DOWNLOAD Carrier Download Batch batch for PIN File Type
And prepaid processes Carrier Acknowledgement batch for PIN File Type
And search with device in device tracking screen and status of carrier
And user sign out from customer portal


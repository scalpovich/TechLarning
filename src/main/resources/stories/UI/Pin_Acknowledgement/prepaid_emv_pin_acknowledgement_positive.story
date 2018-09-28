prepaid emv pin acknowledgement Positive Scenario

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card with pin
As an issuer
I want to create EMV prepaid card with pin and verify positive pin acknowledgement


Meta:
@StoryName p_emv_corp_travel_pin_ack
@TCName TC857949

Scenario: Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
Then user sign out from customer portal

Scenario: Update pin offset file with pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When Pin Offset file was updated with positive pin acknowledgement
Then User uploads the updated PinOffset file to Server

Scenario: Process Batches and verify status of Carrier
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And user processes Send To Carrier batch for PIN File Type and product prepaid
And prepaid processes DOWNLOAD Carrier Download Batch batch for PIN File Type
And prepaid processes Carrier Acknowledgement batch for PIN File Type
And search with device in device tracking screen and status of carrier
Then user sign out from customer portal


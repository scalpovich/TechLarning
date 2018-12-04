debit msr pin acknowledgement Positive Scenario

Narrative:
In order to provide to client easy-to-use general purpose debit card with pin
As an issuer
I want to create MSR debit card with pin and verify positive pin acknowledgement


Meta:
@StoryName d_msr_corp_pin_ack
@TCName TC857949

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
And user sign out from customer portal

Scenario: 2. debit msr corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
Then device has "normal" status
And user sign out from customer portal

Scenario: 3. Update pin offset file with pin acknowledgement and upload it on server
Given Pin Offset file batch was generated successfully
When Pin Offset file was updated with positive pin acknowledgement
Then User uploads the updated PinOffset file to Server

Scenario: 4. Process Batches and verify status of Carrier
Given user is logged in institution
When User creates UPLOAD PIN Offset File Acknowledgement Upload batch
And user processes Send To Carrier batch for PIN File Type and product debit
And debit processes DOWNLOAD Carrier Download Batch batch for PIN File Type
And debit processes Carrier Acknowledgement batch for PIN File Type
Then search with device in device tracking screen and status of carrier
And user sign out from customer portal


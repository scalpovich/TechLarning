perform card setup of photo credit card device
Narrative:
In order to verify card setup of photo credit card device
As a user 
I want to perform card setup of photo credit msr card device

Meta:
@StoryName credit_msr_retail		
	 
	 
	 
Scenario: 1.1 To verify that new batch name named ?Get Photo Card? is present under download batch in Batch level access
Meta:
@TC857968
Given user is logged in customer portal as admin user in default institution
When client photo/flat file download batch is present under download in batch level privilege page

Scenario: 1.2 To verify that Super Admin user is able to provide access for new download batch ?Get Photo Card?  to operations user
Meta:
@TC857970

When admin provides access to download photo/flat file download batch

Scenario: 1.3 To verify the screen details when ?Get Photo Card? batch is selected on Process batches screen
Meta:
@TC857972
Then Date should be displayed as editable on screen
And user sign out from customer portal


Scenario: 1.4 To verify Photo Reference number is present in embossing file generated when new Primary credit device has been boarded through New device screen when card type is selected as photo card
Meta:
@TC857966
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
Then photo reference number is present at given position in embossing file
Then processes Client photo/flat file download batch for new credit Device
Then check status in batch job history for DOWNLOAD batch and CLIENT_PHOTO_BATCH
Then user checks for the client photo/flat file batch trace for download batch
Then new fields are added in device tracking screen
Then photo image file generated in JPEG format
Then photo flat file generated with photo reference number
And process batch for DOWNLOAD type and Batch name CardholderDump
And check status in batch job history for DOWNLOAD batch and CardholderDump
Then photo reference number is present in card holder dump file
And user sign out from customer portal






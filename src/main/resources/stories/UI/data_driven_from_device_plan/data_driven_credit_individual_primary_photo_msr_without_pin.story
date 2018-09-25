perform card setup of photo credit card device
Narrative:
In order to verify card setup of photo credit card device
As a user 
I want to perform card setup of photo credit msr card device

Meta:
@StoryName credit_emv_retail		
	 
Scenario: 1.1 To verify Photo Reference number is present in embossing file generated when new Primary credit device has been boarded through New device screen when card type is selected as photo card
Meta:
@TC857966
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device with photo is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
Then photo reference number present at given position in embossing file
And user sign out from customer portal

Scenario: 2.1 To verify that new batch name named ?Get Photo Card? is present under download batch in Batch level access
Meta:
@TC857968
Given user is logged in institution
Then client photo/flat file download batch is present under download in batch level priviledge page
And user sign out from customer portal

Scenario: 2.2 To verify that Super Admin user is able to provide access for new download batch ?Get Photo Card?  to operations user
Meta:
@TC857970
Given user is logged in customer portal as admin user in default institution
Then admin provides access to download photo/flat file download batch
And user sign out from customer portal

Scenario: 2.3 To verify the screen details when ?Get Photo Card? batch is selected on Process batches screen
Meta:
@TC857972
Given setting json values in excel for Credit
Given user is logged in institution
Then Date should be displayed as editable on screen
And user sign out from customer portal

Scenario: 2.4 To verify that JOB ID is generated and displayed in successful message for Get Photo Card batch scheduling after batch is executed successfully
Meta:
@TC857974
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device with photo is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
Then credit processes Client photo/flat file download batch using new Device
And user sign out from customer portal

Scenario: 2.6 To verify that status(Successful/Failed/In Progress) of scheduled Get Photo Card batch is displayed on batch job history page when searched with either job id or batch name along with schedule date
Meta: 
@TC857976
Given setting json values in excel for Credit
When user is logged in institution
Then check status in batch job history for DOWNLOAD batch and CLIENT_PHOTO_DOWNLOAD
And user sign out from customer portal

Scenario: 2.5 To verify photo files are generated in JPEG format when Get Photo Card batch is successfully executed on saved path in batch definition for the batch
Meta: 
@TC857975
Given setting json values in excel for Credit
Given user is logged in institution
Then photo image file generated in JPEG format
And user sign out from customer portal

Scenario: 2.7 To verify that batch trace is displayed properly for Get Photo Card batch when scheduled in case of successful or failed
Meta: 
@TC857977
Given setting json values in excel for Credit
When user is logged in institution
Then user checks for the client photo/flat file batch trace for download batch
And user sign out from customer portal

Scenario: 4.1 To verify new fields are added in device tracking screen to track photo card file name and photo reference number generated for photo device
Meta: 
@TC857983
Given setting json values in excel for Credit
Given user is logged in institution
Then new fields are added in device tracking screen
And user sign out from customer portal

Scenario: 5.1 To verify user is able to select photo reference numbers for device numbers and generate text file with photo reference number on new screen
Meta:
@TC857984
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device with photo is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
Then credit processes Client photo/flat file download batch using new Device
Then check status in batch job history for DOWNLOAD batch and CLIENT_PHOTO_DOWNLOAD
Then photo flat file generated with photo reference number
And user sign out from customer portal

Scenario: 3.1 To verify photo reference number is present in cardholder dump if new credit device is created through new device and embossing file has been generated on the day
Meta: 
@TC857980
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device with photo is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
And process batch for DOWNLOAD type and Batch name CARDHOLDER_DUMP
And check status in batch job history for DOWNLOAD batch and CARDHOLDER_DUMP
And to verify photo reference number is present in card holder dump file
And user sign out from customer portal

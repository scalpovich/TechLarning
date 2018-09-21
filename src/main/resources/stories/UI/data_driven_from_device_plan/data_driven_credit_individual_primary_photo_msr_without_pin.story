peform credit authorization on msr without pin card
Narrative:
In order to verify credit authorization on msr without pin card
As a user 
I want to peform credit authorization on msr without pin card

Meta:
@StoryName credit_emv_retail		
	 
Scenario:To verify Photo Reference number is present in embossing file generated when new Primary credit device has been boarded through New device screen when card type is selected as photo card
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

Scenario: To verify that new batch name named ?Get Photo Card? is present under download batch in Batch level access
Meta:
@TC857968
Given user is logged in institution
Then client photo/flat file download batch is present under download in batch level priviledge page
And user sign out from customer portal


Scenario:To verify that JOB ID is generated and displayed in successful message for Get Photo Card batch scheduling after batch is executed successfully
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


Scenario:To verify that status(Successful/Failed/In Progress) of scheduled Get Photo Card batch is displayed on batch job history page when searched with either job id or batch name along with schedule date
Meta: 
@TC857976
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
And credit processes Client photo/flat file download batch using new Device
And user checks for the client photo/flat file batch job history status for download batch
And cardholder dump download batch is processed for credit
And user sign out from customer portal

Scenario:To verify that batch trace is displayed properly for Get Photo Card batch when scheduled in case of successful or failed
Meta: 
@TC857977
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
And credit processes Client photo/flat file download batch using new Device
And user checks for the client photo/flat file batch trace for download batch
And user sign out from customer portal

Scenario:To verify new fields are added in device tracking screen to track photo card file name and photo reference number generated for photo device
Meta: 
@TC857983
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
And credit processes Client photo/flat file download batch using new Device
Then new fields are added in device tracking screen
And user sign out from customer portal

Scenario:To verify user is able to select photo reference numbers for device numbers and generate text file with photo reference number on new screen
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
And credit processes Client photo/flat file download batch using new Device
And user checks for the client photo/flat file batch job history status for download batch
Then photo flat file generated with photo reference number
And user sign out from customer portal



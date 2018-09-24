Narrative:
In order to a create a Credit Application under customer portal cardmanagement tab
As a user
I want to assert card creation

Meta:
@CreditRegression
@StoryName credit_card_photocard
Scenario:To verify photo reference number is present in Device production detail report for the credit device for which application is submitted with photo indicator and embossing file is generated
Meta:
@TC857981
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and EMV Card
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And verify photo reference number is present in application production detail report
When to verify photo reference number is present in embossing file
And user sign out from customer portal


Scenario:To verify that new batch name named ?Get Photo Card? is present under download batch in Batch level access
Meta:
@TC857968
@TC857972
@TC857974
@TC857975
@TC857976
@TC857984
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and EMV Card
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And verify new batch named as photo reference number is present under download batch
And check status in batch job history for DOWNLOAD batch and CLIENT_PHOTO_BATCH
Then photo image file generated in JPEG format
When photo flat file generated with photo reference number
And user sign out from customer portal

Scenario:To verify photo reference number is present in cardholder dump if new credit device is created through new device and embossing file has been generated on the day
Meta:
@TC857980
Given setting json values in excel for Credit
When user is logged in institution
When process batch for DOWNLOAD type and Batch name CardholderDump
And check status in batch job history for DOWNLOAD batch and CardholderDump
And to verify photo reference number is present in card holder dump file
And user sign out from customer portal


Scenario:To verify that batch trace is displayed properly for Get Photo Card batch when scheduled in case of successful or failed
@TC857977
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and EMV Card
And user verifies the credit application device
And user approves the credit application device
And user processes close batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And verify new batch named as photo reference number is present under download batch
When user checks for the client photo/flat file batch trace for download batch
And user sign out from customer portal


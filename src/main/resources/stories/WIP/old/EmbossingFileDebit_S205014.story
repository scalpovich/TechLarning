Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:
@EmbossingDebitcard
@all
@UI
@R6releaseAutomation

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@TC264306
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When user creates embossing file template with additional parameters:
|parameters|
|FILLER [FILLER]|
|EXPIRY DATE (MMYY) [EXPIRY_DATE]|
|FILLER [FILLER]|
|SERVICE CODE [SERVICE_CODE]|
|FILLER [FILLER]|
|PVKI [[PVKI]]|
|FILLER [FILLER]|
|PVV [[PVV]]|
|FILLER [FILLER]|             
|CVV [[CVV]]|
|FILLER [FILLER]|
|ICVV [[ICVV]]|
|FILLER [FILLER]|  
|CVV2 [[CVV2]]|
|FILLER [FILLER]|
|CITY [CITY]|
|FILLER [FILLER]|
|STATE [STATE]|
|FILLER [FILLER]|
|COUNTRY [COUNTRY]|
|FILLER [FILLER]|
|ADDRESS LINE 1 [ADDRESS_LINE1]|
|FILLER [FILLER]|
|CARD PACK ID [CARD_PACK_ID]|
|FILLER [FILLER]|
|ADDRESS LINE 2 [ADDRESS_LINE2]|
|FILLER [FILLER]|
|EMBOSSED_NAME [EMBOSSED_NAME]|
|FILLER [FILLER]|
|ICA [ICA]|
|FILLER [FILLER]|
|CARD HOLDER NAME [FIRST_NAME]|
|FILLER [FILLER]|
|Last Name [LAST_NAME]|
|FILLER [FILLER]|
|CARD TYPE [REQUEST_TYPE]|
|FILLER [FILLER]|
|LEGAL_ID [LEGAL_ID]|
And create a PIN offset template with parameters:
|PIN|
|CARD_NUMBER [CARD_NUMBER]|
|FILLER [FILLER]|
|CUSTOMER_NAME [CUSTOMER_NAME]|
|PIN_OFFSET [[PIN_OFFSET]]|
|FILLER [FILLER]|
|SEQUENCE_NUMBER [SEQUENCE_NUMBER]|
|FILLER [FILLER]|
|REQUEST_TYPE [REQUEST_TYPE]|
|FILLER [FILLER]|
|PACK_ID [PACK_ID]|
|PACK_ID_INDICATOR [PACK_ID_INDICATOR]|
|DELIMITER LINE [DELIMITER]|
|UNIQUE_REFERENCE_NUMBER [UNIQUE_REFERENCE_NUMBER]|
|PROGRAM_DESCRIPTION [PROGRAM_DESCRIPTION]|
|PHONE_NUMBER [PHONE_NUMBER]|
|MOBILE_NUMBER [MOBILE_NUMBER]|
|EMBOSSED_NAME [EMBOSSED_NAME]|
|EMAIL_ID [EMAIL_ID]|
|BRANCH_NAME [BRANCH_NAME]|
|BRANCH_CODE [BRANCH_CODE]|
|FILLER [FILLER]|
|ADDRESS_1 [ADDRESS_1]|
|ADDRESS_2 [ADDRESS_2]|
|ADDRESS_3 [ADDRESS_3]|
|ADDRESS_4 [ADDRESS_4]|
|ZIP [ZIP]|
|CITY [CITY]|
|STATE [STATE]|
|COUNTRY [COUNTRY]|
And attach the template to the new device plan of Magnetic stripe card
And executes the device production batch
Then embossing file should be generated in specified location

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@TC264315
@TCName TC264315_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When attach the template to the new device plan of Emv card
And executes the device production batch
Then embossing file should be generated in specified location

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@TC264318
@TCName TC264318_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When attach the template to the new device plan of Physical NFC Device - Mag Stripe Paypass
And executes the device production batch
Then embossing file should be generated in specified location

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@TC264319
@TCName TC264319_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When attach the template to the new device plan of Physical NFC Device - EMV Paypass
And executes the device production batch
Then embossing file should be generated in specified location

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@TC264321
@TCName TC264321_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When attach the template to the new device plan of Physical NFC Device - Paypass
And executes the device production batch
Then embossing file should be generated in specified location

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@Regression
@Smoke
@embossingstatic
@TC264326
@TCName TC264326_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a user
When attach the template to the new device plan of Static Virtual Card
And executes the device production batch
Then embossing file should be generated in specified location
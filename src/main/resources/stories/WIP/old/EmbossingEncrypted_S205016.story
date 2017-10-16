Narrative:
In order to communicate effectively to the business some functionality
As a customer portal user
I want to generate embossing files
So that embossing files generated is in GPG encrypted format


					 
Scenario: TC264613--Embossing File Generation in GPG encrypted format
Meta:
@TC264613
@TCName TC264613_Embossing File Generation in GPG encrypted format
@sheetName S205016
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
And the encrytion flag is enabled
And attach the template to the new device plan of Magnetic stripe card
And executes the device production batch
Then embossing file generated for must be as per the configuration done defined in the embossing file template and must be encrypted

Scenario: TC264627--Embossing File Generation in GPG encrypted format
Meta:
@TC264627
@TCName TC264627_Embossing File Generation in GPG encrypted format
@sheetName S205016
Given login to portal as existing bank as a user 
When the encrytion flag is enabled
And attach the template to the new device plan of Magnetic stripe card
And executes the device production batch
Then embossing file generated for must be as per the configuration done defined in the embossing file template and must be encrypted

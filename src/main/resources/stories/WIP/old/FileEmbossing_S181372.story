Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 


Meta:
@TC216615
@MIIssuingEmboss
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372



Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Given login to existing bank as a user
When user creates embossing file template with additional parameters:
|parameters|
|ADDRESS_LINE3 [ADDRESS_LINE3]|
|FILLER [FILLER]|
|ADDRESS_LINE4 [ADDRESS_LINE4]|
|FILLER [FILLER]|
|PAIR_CARD_INDICATOR [PAIR_CARD_INDICATOR]|
|FILLER [FILLER]|
|VIP_FLAG [VIP_FLAG]|
|FILLER [FILLER]|
|PHOTO_CODE [PHOTO_CODE]|
|FILLER [FILLER]|
|SEQUENCE_NUMBER [SEQUENCE_NUMBER]|
|FILLER [FILLER]|
|DEVICE_NUMBER_LAST_4_DIGIT [DEVICE_NUMBER_LAST_4_DIGIT]|
|FILLER [FILLER]|
|APPLICATION_NUMBER [APPLICATION_NUMBER]|
|FILLER [FILLER]|
|LOYALTY_PLAN_DESCRIPTION [LOYALTY_PLAN_DESCRIPTION]|
|FILLER [FILLER]|
|EMAIL_ID [EMAIL_ID]|
|FILLER [FILLER]|
|DEVICE_NUMBER_FIRST_4_DIGIT [DEVICE_NUMBER_FIRST_4_DIGIT]|
|FILLER [FILLER]|
|LEGAL_ID [LEGAL_ID]|
And attach the template to the device plan
And executes the device production batch
Then embossing file should be generated in specified location








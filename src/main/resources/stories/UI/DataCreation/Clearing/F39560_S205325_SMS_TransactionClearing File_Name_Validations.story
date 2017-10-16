!--S205324 - RCL0003-SMS Transaction-Clearing File-Rupay Incoming

Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:
@F39560
@S205325
@sheetName S181372
Scenario: Verify user successfully uploads a batch upload file with correct naming convension as per RuPay Global Clearing and Settlement Technical Message Specification
@TCName TC264373_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads or is scheduled via TWS the file with incorrect naming convention as per RuPay Global Clearing and Settlement Technical Message Specification 
Then file should not get upload into system	

Scenario: Verify user uploads a batch upload file with incorrect naming convension as per RuPay Global Clearing and Settlement Technical Message Specification see error
@TCName TC264373_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads or scheduled the file with incorrect naming convention as per RuPay Global Clearing and Settlement Technical Message Specification 
Then file should not get upload into system	

Scenario: Verify user uploads a already uploaded file for RuPay Global Clearing and Settlement Technical Message Specification sees error
@TCName TC264373_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads a already uploaded RuPay Clearing and Settlement file
Then file should not get upload into system	and show respective error message

Scenario: Verify user successfully uploads a fresh RuPay Global Clearing and Settlement file which is not uploaded earlier 
@TCName TC264373_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads new RuPay Clearing and Settlement file which is not uploaded earlier 
Then file should get upload into system	and show success message

Scenario: Verify RuPay Global Clearing and Settlement file with all correct parameters get processed by batch upload
@TCName TC264374_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads new RuPay Clearing and Settlement file with all correct parameters
Then entire uploaded file should get processed by batch and show success

Scenario: Verify RuPay Global Clearing and Settlement file with alteast one incorrect parameters doesn't get processed by batch upload
@TCName TC264374_SMS Transaction-Clearing_File_Name_Validations
Given batch upload option is available for processing Rupay Incoming Transactions
When user uploads new RuPay Clearing and Settlement file with atleast one incorrect parameter
Then entire batch upload should get rejected
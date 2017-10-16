Narrative:
As a(n)  Processor 
I want that a new network needs to be added in the platform
So that it is available to all the institutions under the processor 

Meta:
@all
@UI
@RupayBankNetworkConfigforAdmin
@R6releaseAutomation

Scenario: Rupay Network Code Configuration
Meta:
@Regression
@Smoke
@TC264483
@sheetName S205000
@TCName TC264485_Adding Rupay Bank Network Configuration
Given login to existing bank as a Admin
When admin user tries to access the bank network configuration record on the network screen
Then the user must be allowed to change the description of the network configured

Scenario: Rupay Network Code Configuration
Meta:
@Regression
@Smoke
@TC264481
@sheetName S205000
@TCName TC264485_Adding Rupay Bank Network Configuration
Given login to existing bank as a Admin
When admin user tries to download the lists of Bank Network
Then the user must be able to download all the network configured in the excel file format (CSV)
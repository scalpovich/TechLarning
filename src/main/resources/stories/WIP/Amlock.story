!--@author : E052391
!--Feature ID : F45102
!--Story IDs : S248715, S248716

Narrative:
As a(n)  Customer portal user 
I want to generate download reports
So that all reports can be verified


Meta:
@AmlockDownloadReports
@Regression
@all

Scenario: Verify Customer Master Download batch is generated successfully
Meta:
@TCName TC417600_Additional field for Customer Master Download file
@sheetName AmlockDownloads
@testDataFileName
@amlockcustmaster
@R8Regression
Given login to portal as existing bank as a Customeruser
When user generates Customer Master Download batch file for Prepaid product type and FULL extract type
Then the filename will be validated in Customer Master Download batch for each record in file


Scenario: Verify Acount Master Download batch is generated successfully
Meta:
@TCName TC417601_Additional field for Acount Master Download file
@sheetName AmlockDownloads
@testDataFileName
@amlockacctmaster
@R8Regression
Given login to portal as existing bank as a Customeruser
When user generates Acount Master Download batch file for Prepaid product type and FULL extract type
Then the filename will be validated in Acount Master Download batch for each record in file


Scenario: Verify Transaction Master Download batch is generated successfully
Meta:
@TCName TC417602_Additional field for Transaction Master Download file
@sheetName AmlockDownloads
@testDataFileName
@amlocktxnmaster
@R8Regression
Given login to portal as existing bank as a Customeruser
When user generates Transaction Master Download batch file for Prepaid product type and FULL extract type
Then the filename will be validated in Transaction Master Download batch for each record in file


Scenario: Verify Customer Account Relations batch is generated successfully
Meta:
@TCName TC417604_Additional field for Customer Account Relations Download file
@sheetName AmlockDownloads
@testDataFileName
@amlockcustaccount
@R8Regression
Given login to portal as existing bank as a Customeruser
When user generates Customer Account Relations batch file for Prepaid product type and FULL extract type
Then the filename will be validated in Customer Account Relations batch for each record in file


Scenario: Verify ACCOUNT STATUS DOWNLOAD batch is generated successfully
Meta:
@TCName TC417605_Additional field for Account Status Audit Download file
@sheetName AmlockDownloads
@testDataFileName
@amlockacctstatus
@R8Regression
Given login to portal as existing bank as a Customeruser
When user generates ACCOUNT STATUS DOWNLOAD batch file for Prepaid product type and FULL extract type
Then the filename will be validated in ACCOUNT STATUS DOWNLOAD batch for each record in file


Scenario: Verify Transaction Type Master Download batch is generated successfully
Meta:
@TCName TC417606_Additional field for Transaction Type Master Download file
@sheetName AmlockDownloads
@testDataFileName
@amlocktxntypemaster
@R8Regression
Given login to portal as existing bank as a Customeruser
When user downloads Transaction Type Master Download batch file for transactiontype for Prepaid product type
Then the filename will be validated in Transaction Type Master Download batch for each record in file


Scenario: Verify Employee Master User batch is generated successfully
Meta:
@TCName TC417607_Additional field for Employee Master User Download file
@sheetName AmlockDownloads
@testDataFileName
@amlockempmaster
@R8Regression
Given login to portal as existing bank as a Customeruser
When user downloads Employee Master User batch file for employeemaster for Agency [5] entity type and FULL extract type
Then the filename will be validated in Employee Master User batch for each record in file


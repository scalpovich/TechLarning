Narrative:
In order to communicate effectively to the business some functionality
As a(n) customer portal user

I want to a new configuration setup to define settlement bins provided by NPCI for an institution
So that device bin, settlement bin, product code and participant id shared by NPCI can be configured on the platform for validations and necessary outgoing file generation.

Meta:
@RupaySettlementMakerChecker
@R6releaseAutomation
 
					 
Scenario:  TC264377--Adding of RuPay Settlement Bin record-- Maker Checker
Meta:
@TC264377
@TCName TC264377_Adding of RuPay Settlement Bin record Maker Checker
@sheetName S205010
Given  customer portal user has access and privilege to configure
When the customer portal user adds the record
Then audit for all the records added, amended or deleted should be maintained and also Maker Checker feature needs to be enabled for the screen.
					 
Scenario:  TC266324--Editing of record for RuPay Settlement Bin -- Maker Checker
Meta:
@TC266324
@TCName TC266324_Editing of record for RuPay Settlement Bin -- Maker Checker
@sheetName S205010
Given  a customer portal user has access and privilege to configure
When the customer portal user edited the record
Then Audit for all the records edited should be maintained and also Maker Checker feature needs to be enabled for the screen.
					 
Scenario:  TC266395--Delete functionality for RuPay Settlement Bin Configuration -- Maker Checker
Meta:
@TC266395
@TCName TC266395_Delete functionality for RuPay Settlement Bin Configuration -- Maker Checker
@sheetName S205010

Given Customer portal user has access and privilege to do configurations
When the customer portal user deletes the record
Then Audit for all the records deleted should be maintained and also Maker Checker feature needs to be enabled for the screen

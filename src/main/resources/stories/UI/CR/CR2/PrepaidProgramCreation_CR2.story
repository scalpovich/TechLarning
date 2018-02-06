!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Prepaid Program
So that program can be created with different data conditions

Meta:
@PrepaidProgramCR2

Scenario: Scenario1 - Verify that the Issuer is able to create/define a Prepaid Program: Retail General Purpose Card for Multi Wallet Single Currency Type  - Using data condition: DMS, Device Technology (VISA Interface), EMV 
Meta:
@CR2
@CR
@all
@PrepaidProgramRetailGeneralMultiWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid
When user creates a Closed loop wallet plan of White listed MCG type for program Retail General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Visa for Emv and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Visa for product Prepaid for program Retail General Purpose
Then Program should get created

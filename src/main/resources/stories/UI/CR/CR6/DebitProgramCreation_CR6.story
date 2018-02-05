!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Debit Program
So that program can be created with different data conditions

Meta:
@CRProgram
@DebitProgramCR6

Scenario: Scenario1 - Verify that the Issuer is able to create/define a Debit Program:  ATM Admin Card Type 
Meta:
@CR
@CR6
@all
@DebitProgramATMAdmin
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program ATM Admin Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for ATM Admin Card and Debit card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Debit for program ATM Admin Card
Then Program should get created

Scenario: Scenario2 - Verify that the Issuer is able to create/define a Debit Program:  Corporate Debit Card for Single Wallet Single Currency Type 
Meta:
@CR
@CR6
@all
@DebitProgramCorporateDebit
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate Debit Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Emv and Debit card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Debit for program Corporate Debit Card
Then Program should get created
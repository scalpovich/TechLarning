!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Debit Program
So that program can be created with different data conditions

Meta:
@DebitProgramCR4

Scenario: Scenario1 - Verify that the Issuer is able to create/define a Debit Program:  Retail Debit Card for Single Wallet Single Currency Type. - Using data condition: SMS, Device Technology (mastercard Interface), Static Virtual Card 
Meta:
@CR
@CR4
@all
@DebitProgramRetailDebit
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail Debit Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Debit card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Debit for program Retail Debit Card
Then Program should get created
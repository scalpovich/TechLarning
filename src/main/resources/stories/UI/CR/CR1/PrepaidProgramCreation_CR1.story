!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Prepaid Program
So that program can be created with different data conditions

Meta:
@CRProgram
@PrepaidProgramCR1

Scenario: Scenario1 - Verify that the Issuer is able to create/define a Prepaid Program: Retail Travel Card for Multi Wallet Multi Currency Type  - Using data condition: DMS, Device Technology (mastercard Interface), EMV 
Meta:
@CR1
@CR
@all
@PrepaidProgramRetailTravelMultiWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail Travel Card for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Visa for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Visa for product Prepaid for program Retail Travel card - Multi currency
Then Program should get created

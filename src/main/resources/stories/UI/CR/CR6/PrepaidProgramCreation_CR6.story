!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Prepaid Program
So that program can be created with different data conditions

Meta:
@CRProgram
@PrepaidProgramCR6

Scenario: Scenario1 - Verify that the Issuer is able to create/define a Prepaid Program: Corporate General Purpose Card for Multi Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramCorporateGeneralMultiWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid
When user creates a Closed loop wallet plan of White listed MCG type for program Corporate General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Mastercard for product Prepaid for program Corporate General Purpose
Then Program should get created

Scenario: Scenario2 - Verify that the Issuer is able to create/define a Prepaid Program: Corporate General Purpose Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramCorporateGeneralSingleWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose
Then Program should get created

Scenario: Scenario3 - Verify that the Issuer is able to create/define a Prepaid Program: Corporate Gift Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramCorporateGiftMultiWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate Gift Card for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Mastercard for product Prepaid for program Corporate Gift Card
Then Program should get created

Scenario: Scenario4 - Verify that the Issuer is able to create/define a Prepaid Program: Corporate Travel Card for Multi Wallet Multi Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramCorporateTravelMultiWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency
Then Program should get created

Scenario: Scenario5 - Verify that the Issuer is able to create/define a Prepaid Program: Corporate Travel Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramCorporateTravelSingleWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate Travel card - Single currency for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency
Then Program should get created

Scenario: Scenario6 - Verify that the Issuer is able to create/define a Prepaid Program: Retail General Purpose Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramRetailGeneralSingleWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose
Then Program should get created

Scenario: Scenario7 - Verify that the Issuer is able to create/define a Prepaid Program: Retail Gift Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramRetailGiftSingleWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail Gift Card for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail Gift Card
Then Program should get created

Scenario: Scenario8 - Verify that the Issuer is able to create/define a Prepaid Program: Retail Travel Card for Single Wallet Single Currency Type 
Meta:
@CR6
@CR
@all
@PrepaidProgramRetailTravelSingleWallet
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail Travel card - Single currency for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail Travel card - Single currency
Then Program should get created

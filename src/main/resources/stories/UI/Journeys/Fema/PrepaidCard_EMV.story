!-- author: e060549

Narrative:
As a Customer portal user 
I want to create Emv prepaid cards as per FEMA configuration
So that  I can use use these cards for transactions


Meta:
@R7Regression
@FemaPrepaidEmv

Scenario: Scenario1 - Verify that the Issuer is able to create Corporate Travel Card-single currency for Single Wallet Single Currency Type
Meta:
@CorporateTravelSingleCurrencyEmv
@TCName TC264315_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate Travel card, single wallet single currency for Emv
Then user should be able to create EMV Card for Prepaid product for Corporate customer

Scenario: Scenario2 - Verify that the Issuer is able to create Corporate Travel Card-Multi currency for Multi Wallet Multi Currency Type 
Meta:
@CorporateTravelMultiCurrencyEmv
@TCName TC264315_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Emv
Then user should be able to create EMV Card for Prepaid product for Corporate customer
When user defines the service code as Currency Setup and creates 2 wallets for prepaid card
Then the prepaid card should be a multiwallet card

Scenario: Scenario3 - Verify that the Issuer is able to create Retail Travel Card for Single Wallet Single Currency Type  
Meta:
@RetailTravelSingleCurrencyEmv
@TCName TC264315_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail Travel card, Single Wallet Single Currency for Emv
Then user should be able to create EMV Card for Prepaid product for Individual customer

Scenario: Scenario4 - Verify that the Issuer is able to create Retail Travel Card for Multi Wallet Multi Currency Type  
Meta:
@RetailTravelMultiCurrencyEmv
@TCName TC264315_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Emv
Then user should be able to create EMV Card for Prepaid product for Indivdual customer
When user defines the service code as Currency Setup and creates 2 wallets for prepaid card
Then the prepaid card should be a multiwallet card
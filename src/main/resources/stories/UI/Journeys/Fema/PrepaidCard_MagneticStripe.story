!-- author: e060549

Narrative:
As a Customer portal user 
I want to create Magnetic Stripe prepaid cards as per FEMA configuration
So that  I can use use these cards for transactions


Meta:
@R7Regression
@FemaPrepaidMagneticStripe

Scenario: Scenario1 - Verify that the Issuer is able to create Corporate Travel Card-single currency for Single Wallet Single Currency Type
Meta:
@CorporateTravelSingleCurrency
@TCName TC264306_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate Travel card, single wallet single currency for MagStripe
Then user should be able to create Magnetic Stripe card for Prepaid product for Corporate customer

Scenario: Scenario2 - Verify that the Issuer is able to create Corporate Travel Card-Multi currency for Multi Wallet Multi Currency Type 
Meta:
@CorporateTravelMultiCurrency
@TCName TC264306_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for MagStripe
Then user should be able to create Magnetic Stripe card for Prepaid product for Corporate customer
When user defines the service code as Currency Setup and creates 2 wallets for prepaid card
Then the prepaid card should be a multiwallet card

Scenario: Scenario3 - Verify that the Issuer is able to create Retail Travel Card for Single Wallet Single Currency Type  
Meta:
@RetailTravelSingleCurrency
@TCName TC264306_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail Travel card, Single Wallet Single Currency for MagStripe
Then user should be able to create Magnetic Stripe card for Prepaid product for Individual customer

Scenario: Scenario4 - Verify that the Issuer is able to create Retail Travel Card for Multi Wallet Multi Currency Type  
Meta:
@RetailTravelMultiCurrency
@TCName TC264306_Embossing File Generation
@sheetName S205014
@Stage
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail Travel card, Multi Wallet Multi Currency for MagStripe
Then user should be able to create Magnetic Stripe card for Prepaid product for Individual customer
When user defines the service code as Currency Setup and creates 2 wallets for prepaid card
Then the prepaid card should be a multiwallet card
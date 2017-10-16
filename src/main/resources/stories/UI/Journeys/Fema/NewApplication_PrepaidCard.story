Narrative:
As a Customer portal user 
I want to create New Application prepaid cards as per FEMA configuration
So that  I can use use these cards for transactions


Meta:
@NewApplication
@R7
@all
Scenario: Scenario1 - Verify that the Issuer is able to create Corporate Travel Card-single currency for Single Wallet Single Currency Type
Meta:
@Regression
@NewApplicationCreationPrepaid
@TCName TC_ApplicationCreationForCorporate
@sheetName NewApplication
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate Travel card, single wallet single currency
When user navigates to New device in Activity of crad managment tab
Then user creates a new application for Prepaid product type

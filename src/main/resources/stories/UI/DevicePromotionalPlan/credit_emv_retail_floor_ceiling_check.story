Narrative:
In order to validate Device Promotion Plan Priority
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail_Limits

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And user uses existing transaction limit plan for limit type TX_LIMIT_PLAN
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And user attachs device promotion plan PROMOTION_PLAN
And device has "normal" status
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction less than DPP and more than DP Floor Limit
Given connection to MAS is established
When user updates transaction amount to 140
And perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: 1.4 Perform EMV_PURCHASE Authorization transaction to check Ceiling Amount Check
Given user updates transaction amount to 10
And perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert 32000 response with Decline AuthDecline Code and Transaction amount is less than Minimum amount configured at device promo level. as description
And user sign out from customer portal
And MAS simulator is closed
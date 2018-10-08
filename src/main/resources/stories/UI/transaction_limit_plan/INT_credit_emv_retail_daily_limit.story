Narrative:
In order to validate transaction limit, velocity and usage amount
As an issuer
I want to perform transaction

Meta:
@StoryName credit_emv_retail_Limits
@INT_DailyLimit
@CreditTxLimits
@Limits

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And user uses existing transaction limit plan for limit type INT_DAILY
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario: 1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 1.3 Perform INT_EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When user updates transaction amount to 15
And perform an INT_EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Authorization Search page validation
Given user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.5 Update Transaction Amount More than Allowed Periodic Amount
When user updates transaction amount to 11

Scenario: 1.6 Perform INT_EMV_PURCHASE Authorization transaction to check Exceeds Amount Limit
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34003 AuthDecline Code and Transaction exceeded with Daily amount configured at device plan level. as description
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal

Scenario: 1.7 Update Transaction Amount Less than Allowed Periodic Amount
When user updates transaction amount to 3
 
Scenario: 1.8 Perform INT_EMV_PURCHASE Authorization transaction with allowed amount
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.9 Perform INT_EMV_PURCHASE Authorization transaction to check Frequency Exceeded
When perform an INT_EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And user validates device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34002 AuthDecline Code and Transaction exceeded with daily velocity configured at device plan level. as description
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal
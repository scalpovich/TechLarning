
Narrative:
In order to validate transaction limit, velocity and usage amount
As an issuer
I want to perform transaction 

Meta:
@StoryName credit_emv_retail_Limits
@PeriodicLimit
@CreditTxLimits
@Limits

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And user uses existing transaction limit plan for limit type PERIODIC
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

Scenario: 1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Authorization Search page validation
Given user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user validates device usage for Periodic Velocity Utilized and Periodic Amount Utilized
And user sign out from customer portal

Scenario: 1.5 Update Transaction Amount More than Allowed Periodic Amount
When user updates transaction amount to 21

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction to check Exceeds Amount Limit
Given perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And user validates device usage for Periodic Velocity Utilized and Periodic Amount Utilized
And assert Decline response with 34005 AuthDecline Code and Transaction exceeded with periodic amount configured at device plan level. as description
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal

Scenario: 1.7 Update Transaction Amount Less than Allowed Periodic Amount
When user updates transaction amount to 10
 
Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction with allowed amount
Given perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user validates device usage for Periodic Velocity Utilized and Periodic Amount Utilized
And user sign out from customer portal

Scenario: 1.9 Perform EMV_PURCHASE Authorization transaction to check Frequency Exceeded
Given perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And user validates device usage for Periodic Velocity Utilized and Periodic Amount Utilized
And assert Decline response with 34004 AuthDecline Code and Transaction exceeded with periodic velocity configured at device plan level. as description
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal
And MAS simulator is closed
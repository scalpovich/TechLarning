Narrative:
In order to validate transaction limit, velocity and usage amount
As an issuer
I want to perform transaction

Meta:
@StoryName prepaid_emv_retail_Limits
@DailyLimit
@Limits

Scenario: 1.1 Create EMV prepaid device
Given setting json values in excel for Prepaid
When user is logged in institution
And user use existing transaction limit plan for limit type YEARLY
And for EMV Card User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product and program Retail prepaid Card
And User Primary Device fills New Program Retail prepaid Card section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And prepaid processes pre-production batch using new Device
And prepaid processes deviceproduction batch using new Device for Supplementary
And prepaid processes pinProduction batch using new Device for Supplementary
And device has "normal" status
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
And user validate device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.5 Update Transaction Amount More than Allowed Periodic Amount
When user update transaction amount to 21

Scenario: 1.6 Perform EMV_PURCHASE Authorization transaction to check Exceeds Amount Limit
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 121-Exceeds Amount Limit status
And user validate device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34005 AuthDecline Code and Transaction exceeded with daily amount configured at device plan level. as description
And user sign out from customer portal

Scenario: 1.7 Update Transaction Amount Less than Allowed Periodic Amount
When user update transaction amount to 10
 
Scenario: 1.8 Perform EMV_PURCHASE Authorization transaction with allowed amount
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user validate device usage for Daily Velocity Utilized and Daily Amount Utilized
And user sign out from customer portal

Scenario: 1.9 Perform EMV_PURCHASE Authorization transaction to check Frequency Exceeded
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 123-Frequency Exceeded status
And user validate device usage for Daily Velocity Utilized and Daily Amount Utilized
And assert Decline response with 34004 AuthDecline Code and Transaction exceeded with periodic daily configured at device plan level. as description
And user sign out from customer portal
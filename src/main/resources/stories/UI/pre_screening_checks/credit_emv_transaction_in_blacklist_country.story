credit card transaction at white/black listed country

Narrative:
In order to provide to transaction in white/black listed country
As an issuer
I want to make transaction at black listed country via credit card

Meta:
@StoryName credit_emv_retail_trx_in_black_list_country				 
@CountryWhiteBlackListPreScreening
Scenario:creation of mastercard_individual_primary_emv Card credit device
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And User edit Program to update country white black list
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal


Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 25002 AuthDecline Code and Country is blacklisted. as description
Then user sign out from customer portal
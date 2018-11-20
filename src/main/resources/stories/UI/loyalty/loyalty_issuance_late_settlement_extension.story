Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram with issuance promotion plan
In order to verify loyalty points are not accrued when device is boarded in late settlement extension period
Meta:
@StoryName credit_msr_retail_loyalty
@migration_loyalty

Scenario: Create credit device in late settlement extension period and verify loyalty points
Given setting json values in excel for Credit
Then use loyalty plan AUTOMATION [LP1]
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And user selects all the transactions for loyalty transaction plan
Then promotion plan PROMO1 expiry date is updated to yesterday
When User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user has loyalty points details for Credit device
Then verify loyalty points are not credited on issuance for promotion plan code PROMO1
And promotion plan PROMO1 expiry date is updated to future
And user sign out from customer portal

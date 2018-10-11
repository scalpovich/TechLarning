Narrative:
As a Customer portal user
I want to validate card level credit card limit for retail card
so that account level credit card limit should be validated

Meta:
@StoryName credit_emv_retail_acount_card_limit

Scenario:1.1 To Verify that the user can validate credit transaction limit for retail card
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And user edits the program to enable card credit limit
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user raises Permanent [P] credit limit change request for Individual
Then user sign out from customer portal

Scenario:1.2 Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform MSR_PURCHASE Authorization transaction to validate otb at card level limit
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And MAS simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 116-Insufficient Fund status
And assert Decline response with 90004 AuthDecline Code and Card level - insufficient otbl defined at card level. as description
And user sign out from customer portal
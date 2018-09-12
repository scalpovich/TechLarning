credit emv verification of joining and membership fee

Narrative:
In order to provide to client easy-to-use multi-purpose credit card pinless
As an issuer
I want to create EMV Credit card pinless and verify joining and membersip fee

Meta:
@StoryName credit_emv_retail_promotion

Scenario: Set up credit msr retail general purpose card device production
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Joining and MemberShip Fees is been Deducted
Given user is logged in institution
Then search with device in transaction screen and status for Joining and Membership Fees
And user signs out from customer portal
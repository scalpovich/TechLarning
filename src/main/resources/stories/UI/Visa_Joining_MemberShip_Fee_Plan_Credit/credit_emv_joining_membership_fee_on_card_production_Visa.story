credit emv verification of joining and membership fee

Narrative:
In order to provide to client easy-to-use multi-purpose credit card pinless
As an issuer
I want to create EMV Credit card pinless and verify joining and membersip fee

Meta:
@StoryName credit_emv_retail_cardproduction
@JMFCreditPlans

Scenario: Set up credit emv retail general purpose card device production
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Visa
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal

Scenario: Post maintenance batch and pre-clearing batch is run 
Given user is logged in institution
When post maintenance batch is run
And user processes Pre-clearing system internal batch for Credit
Then user sign out from customer portal

Scenario: Joining and MemberShip Fees is been Deducted
Given user is logged in institution
When search with device in transaction screen and status for Joining and Membership Fees
Then user signs out from customer portal


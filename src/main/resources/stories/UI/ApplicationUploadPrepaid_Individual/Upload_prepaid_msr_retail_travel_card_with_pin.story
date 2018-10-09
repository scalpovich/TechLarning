prepaid msr retail travel card authorization

Narrative:
In order to check transactions on prepaid msr retail travel card
As an issuer
I want to authorize transactions for prepaid msr retail travel card 

Meta:
@StoryName p_msr_retail_travel

Scenario: Set up prepaid msr retail travel card
Meta:
@TestId
Given setting json values in excel for Prepaid
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Retail Travel Card - Single Currency [1]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Retail Travel Card - Single Currency [1] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload prepaid batch file and upload it on server for Individual for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And processes prepaid pin production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
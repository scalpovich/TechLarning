prepaid msr retail general purpose card authorization

Narrative:
In order to check transactions on prepaid msr retail general purpose card 
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card 

Meta:
@StoryName p_msr_retail_gen_purpose

Scenario: Set up prepaid msr retail general purpose card
Meta:
@TestId TC398484
Given setting json values in excel for Prepaid
When user is logged in institution
And for Magnetic Stripe Card [1] User fills without pin Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Retail General Purpose Card [4] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload prepaid batch file and upload it on server for Individual for prepaid
And prepaid processes pre-production batch using new Application for fileUpload in Bulk from jobid
And All processes prepaid device production batch for fileUpload in Bulk from jobid
And For fileUpload when user search for new application on search screen for prepaid and validates the status as NORMAL
Then user logouts from customer portal
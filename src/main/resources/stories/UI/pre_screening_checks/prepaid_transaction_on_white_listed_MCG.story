prepaid card transaction in white listed MCG
Narrative:
In order to provide to transaction white listed MCG
As an issuer
I want to make transaction at white listed MCG via prepaid card

Meta:
@StoryName prepaid_card_trx_at_white_list_country

Scenario: Set up prepaid msr retail general purpose card
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
Then User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And User fills MCC Rules for prepaid product
And User fills Dedupe Plan
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And User fills Device Plan for "prepaid" "magnetic stripe" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user creates new device of prepaid type for new client
And device has "normal" status
And user sign out from customer portal
And user creates new device of prepaid type for new client
And device has "normal" status
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When a new device was created
Then processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal


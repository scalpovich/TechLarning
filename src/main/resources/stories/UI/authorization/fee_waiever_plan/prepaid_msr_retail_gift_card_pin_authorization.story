prepaid msr retail gift card authorization PINLESS

Narrative:
In order to check transactions on prepaid msr retail gift card 
As an issuer
I want to authorize transactions for prepaid msr retail gift card 

Meta:
@StoryName p_msr_retail_gift

Scenario: Transaction - prepaid msr retail gift card - MSR_PURCHASE_WITH_CASHBACK Authorization transaction
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
And User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And User fills MCC Rules for prepaid product
And User fills Dedupe Plan
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And User fills Device Plan for prepaid magnetic stripe card with transaction fee waived Off
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
And verify transaction fee waived off
And user sign out from customer portal
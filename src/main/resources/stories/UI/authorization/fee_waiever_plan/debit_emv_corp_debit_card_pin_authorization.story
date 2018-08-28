debit emv corporate card authorisation

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp

Scenario: Transaction - debit emv corp debit card - EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Given user is logged in institution
When User fills Dedupe Plan
And User fills MCC Rules for debit product
And User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And User fills Device Plan for debit emv card with transaction fee waived Off
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
And verify transaction fee waived off
And user sign out from customer portal
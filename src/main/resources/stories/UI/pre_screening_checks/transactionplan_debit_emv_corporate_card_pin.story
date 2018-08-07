Narrative:
In order to test transaction plan without assigned transaction for debit emv corporate card
As an issuer
I want to fail transactions for prepaid emv corporate card
Meta:
@StoryName d_emv_corp
@TransactionPlanWithoutAssignTransactions

Scenario: Set up debit emv corporate travel card
Given user is logged in institution
When User fills Dedupe Plan
And User fills MCC Rules for debit product
And User create empty Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And User fills Device Plan for "debit" "emv" card
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
Then user sign out from customer portal

Scenario: debit emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user has wallet number information for debit device
And user sign out from customer portal
And user is logged in institution
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File
And embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 119-Transaction not permitted status
And assert Decline response with 10001 AuthDecline Code and Transaction not permitted to device holder. as description
And user sign out from customer portal
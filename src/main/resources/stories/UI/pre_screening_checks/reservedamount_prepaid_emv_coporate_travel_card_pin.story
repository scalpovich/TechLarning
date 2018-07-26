Narrative:
In order to check minimum wallet balance/reserved amount on prepaid emv corporate travel card
As an issuer
I want to perform transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel

Scenario: Set up prepaid emv corporate travel card
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
And User fills Device Plan for "prepaid" "emv" card
And User fills Wallet Plan for prepaid product and 100 reserved amount
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
And user is logged in institution
When user performs adjustment transaction with 105 amount
And user has current wallet balance amount information for prepaid device
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
Then user is logged in institution
And search Purchase authorization and verify 116-Insufficient Fund status
And assert Decline response with 46020 AuthDecline Code and Below Minimum balance. as description
And user sign out from customer portal
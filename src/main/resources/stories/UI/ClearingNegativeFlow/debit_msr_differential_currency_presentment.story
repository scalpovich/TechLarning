Narrative:
In order to validate transaction is matched with authorization for Mastercard when presentment is uploaded after card is stop listed
As a Issuer
I want to perform transaction clearing on card which is stoplisted after Authorization

Meta:
@StoryName d_msr_corp
@ClearingNegativeScenario
 
Scenario: 1.1 Set up program for debit MSR corporate debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "magnetic stripe" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device

Scenario: 1.2 debit msr corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: 1.3 Perform MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: 1.4 Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: 1.5 Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
And Auth file is loaded into MCPS and processed
And user update IPM file to get status Differential currency presentment
Then NOT file is successfully generated
And MCPS simulator is closed

Scenario: 1.6 Upload ipm file from customer portal and process it
Meta:
@TestId
Given user is logged in institution
When User uploads the NOT file
And user processes batch for debit
Then user sign out from customer portal

Scenario: 1.7 Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
And "Matching" batch for debit is successful
And transaction status is "Differential currency presentment"
Then user sign out from customer portal
Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV prepaid card

Meta:
@Author Nitin Kumar
@StoryName p_emv_retail_general

Scenario:1 Set up prepaid emv retail general purpose card
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
And user sign out from customer portal

Scenario:2 prepaid EMV retail general purpose card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:4 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_HRM MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:5 validate the High Risk MCC Report
Given user is logged in institution
Then validate the MCC in RAMP-REP05 report
And user sign out from customer portal

Scenario:6 validate the High Risk Country Report
Given user is logged in institution
Then validate the Country in RAMP-REP04 report
And user sign out from customer portal

Scenario:7 validate the High Risk Merchant Location Report
Given user is logged in institution
Then validate the Merchant in RAMP-REP06 report
And user sign out from customer portal

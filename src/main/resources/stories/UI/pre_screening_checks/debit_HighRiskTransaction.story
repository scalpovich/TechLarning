Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV Debit card

Meta:
@HighRiskTransaction
@Author Nitin Kumar
@StoryName d_emv_retail

Scenario: Set up prepaid emv retail general purpose card
Given setting json values in excel for Debit
And user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client

Scenario: prepaid EMV retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
And processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_HRM_PIN MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: validate the High Risk Country Report
Given user is logged in institution
And validate the authCode in RAMP-REP05 report


Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV prepaid card

Meta:
@HighRiskTransaction_p
@Author Nitin Kumar
@StoryName p_emv_retail_general

Scenario: Set up prepaid emv retail general purpose card
Given setting json values in excel for Prepaid
And user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
And user sign out from customer portal


Scenario: prepaid msr retail general purpose card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And embossing file batch was generated in correct format
Then user sign out from customer portal


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


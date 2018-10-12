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
When User fills Device Plan for "Prepaid" "emv" card without pin
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
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an ECOMM_PURCHASE_DE MAS transaction
Then MAS test results are verified
Then MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
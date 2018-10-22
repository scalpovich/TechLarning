Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card to check differenr status Refer/Capture.

Meta:
@StoryName d_emv_corp				 

Scenario:1.1 Set up debit emv corporate travel card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "debit" "emv" card for issuer scripting
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "NOT ACTIVATED CARD [11]" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario:1.2 Check Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline all non secured transaction for product Debit and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 80019 AuthDecline Code and Non Secure Transaction as description
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.5 Uncheck Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline all non secured transaction for product Debit and interchange Mastercard as uncheck
Then user sign out from customer portal
Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card to check 3D Secure Decisioning Transaction

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
And user activates device through helpdesk
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario:1.2 Check Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline Merchant Risk Based Decisioning Transaction for product Debit and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.4 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
Given User set Decline Merchant Risk Based Decisioning Transaction flag true
When perform an 3D_SECURE_CAVV MAS transaction
And user is logged in institution
And search E-Commerce Transaction* authorization and verify 100-Do Not Honour status
And assert Decline response with 80040 AuthDecline Code and Merchant Risk Based Decisioning. as description
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.5 Uncheck Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits 3D ecommerce security parameters to Decline Merchant Risk Based Decisioning Transaction for product Debit and interchange Mastercard as uncheck
Then user sign out from customer portal
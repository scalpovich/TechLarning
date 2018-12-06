Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate prepaid card to check 3D Secure Decisioning Transaction

Meta:
@StoryName p_emv_corp_travel				 

Scenario:1.1 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And user edits All field of 3D Ecom Security for product prepaid and interchange MasterCard as uncheck
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:1.2 Check Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits Decline Merchant Risk Based Decisioning Transaction field of 3D Ecom Security for product prepaid and interchange MasterCard as check and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
Given User sets Decline Merchant Risk Based Decisioning Transaction flag true
When perform an 3D_SECURE_CAVV MAS transaction
And user is logged in institution
And search E-Commerce Transaction* authorization and verify 100-Do Not Honour status
And assert Decline response with 80040 AuthDecline Code and Merchant Risk Based Decisioning. as description
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.4 Uncheck Decline All Non Secured Transaction Check
Given user is logged in institution
When user edits Decline Merchant Risk Based Decisioning Transaction field of 3D Ecom Security for product prepaid and interchange MasterCard as uncheck
Then user sign out from customer portal
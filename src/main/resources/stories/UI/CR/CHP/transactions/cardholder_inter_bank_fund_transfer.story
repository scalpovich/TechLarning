Narrative:
As a Cardhodler
I want to login into cardholder portal 
In order to do the transactions


Meta:
@StoryName CHP_CS
@SanityCards

Scenario:1 To check functionality of wallet fund transfer by emv card with program Corporate Travel Card - Multi Currency on cardholder portal
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card with no pin
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Business Mandatory Fields Screen for prepaid product with Corporate
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And processes pre-production batch for prepaid
And processes device production batch for prepaid
Then device has "normal" status
And user performs adjustment transaction
And currency setup for device
And user sign out from customer portal

Scenario:2 To validate inter bank fund transfer transction
Given user is on login page of cardholder portal
And cardholder complete registration and login into portal
When check wallet to wallet transfer
And user is logged in institution
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal
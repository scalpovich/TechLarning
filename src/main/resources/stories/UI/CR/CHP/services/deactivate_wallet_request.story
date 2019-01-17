Narrative:
As a cardhodler
I want to login into cardholder portal 
In order to assert cardholder services for given card

Meta:
@StoryName CHP_CS
@SanityCards

Scenario:1 To check functionality of wallet fund transfer by emv card with program Corporate Travel Card - Multi Currency on cardholder portal
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card with no pin
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And processes pre-production batch for prepaid
And processes device production batch for prepaid
Then device has "normal" status
And user sign out from customer portal

Scenario:2 Deactivate associated wallet
Given user is on login page of cardholder portal
When cardholder complete registration and login into portal
And select wallet for operation
Then deactivate associated wallet for selected device
Then user logs out from cardholder portal

Scenario:3 Validate service request status
Given user is logged in institution
Then verify "Activate/Deactivate Wallet [313]" service request status
And user sign out from customer portal
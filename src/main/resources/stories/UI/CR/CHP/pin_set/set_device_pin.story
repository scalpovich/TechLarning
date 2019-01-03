Narrative:
As a Cardhodler
I want to login into cardholder portal
In order to send PIN Set request

Meta:
@StoryName CHP_CS

Scenario:1 To check functionality of wallet fund transfer by emv card with program Corporate Travel Card - Multi Currency on cardholder portal
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And processes pre-production batch for prepaid
And processes device production batch for prepaid
Then device has "normal" status
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:2 To update Pin for selected for device
Given user is on login page of cardholder portal
When cardholder complete registration and login into portal
And select wallet for operation
Then PIN set request for card
And user logouts from cardholder portal
Narrative:
As a cardhodler
I want to login into cardholder portal 
In order to validate service request for create virtual card

Meta:
@StoryName CHP_CS

Scenario:1 To check functionality of wallet fund transfer by emv card with program Corporate Travel Card - Multi Currency on cardholder portal
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card with no pin
And for Static Virtual Card [7] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User Add-on Device fills Existing Program Corporate Travel Card - Multi Currency [6] section for prepaid product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for prepaid product
And for Add-on Device and Existing Client user fills Device Range section for prepaid product
And add menus to access card holder portal
And prepaid device is created using new device screen for Corporate [1] and Primary Device [P] and New Client [N] and EMV Card [2]
And processes pre-production batch for prepaid
And processes device production batch for prepaid
Then device has "normal" status
And user sign out from customer portal

Scenario:2 Service request for create virtual card 
Given user is on login page of cardholder portal
When cardholder complete registration and login into portal
Then service request for static virtual Card
And user logouts from cardholder portal

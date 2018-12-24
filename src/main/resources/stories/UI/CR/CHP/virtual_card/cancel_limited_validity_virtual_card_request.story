Narrative:
As a cardhodler
I want to login into cardholder portal
In order to validate service request for create limited validity virtual card

Meta:
@StoryName CHP_CS

Scenario:1 To validate create emv device of prepaid type
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card with no pin
And for Limited Validity Virtual Card [8] User fills Supplementary Device Plan for prepaid product for MASTERCARD [02]
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

Scenario:2 Service request for create limited  validity virtual card 
Given user is on login page of cardholder portal
When cardholder complete registration and login into portal
Then service request to create Limited Validity Virtual Card [8]

Scenario:3 Cancel the requested limited validity virtual card 
Given select "Limited Validity Virtual Card" for operation
Then cancel limited validity virtual card request
And user logouts from cardholder portal
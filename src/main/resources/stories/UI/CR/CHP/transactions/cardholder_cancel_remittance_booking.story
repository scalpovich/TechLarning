Narrative:
As a Cardhodler
I want to login into cardholder portal 
In order to do the transactions


Meta:
@StoryName CHP_CS
@SanityCards

Scenario:1 To check functionality of prepaid card creation of emv type
Given setting json values in excel for Prepaid
And user is logged in institution
When User fills Device Plan for "prepaid" "emv" card with no pin
And fills Wallet Plan for prepaid product and program Retail General Purpose Card [4]
And User fills Program section for prepaid product and program Retail General Purpose Card [4]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Individual [0] customer
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user performs adjustment transaction
Then device has "normal" status
And user sign out from customer portal

Scenario:2 User can be able to cancel the cash remittance request
Given user is on login page of cardholder portal
When cardholder complete registration and login into portal
And cardholder book the cash remittance
Then cardholder cancel the cash remittance
And user logs out from cardholder portal
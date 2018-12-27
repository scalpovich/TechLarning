Narrative:
As a Cardhodler
I want to able to login into cardholder portal 
In order to do the transactions


Meta:
@StoryName MMS_TRAN
@SanityCards


Scenario: To Verify functionality of mastercard money send from Cardholder
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
And User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And User fills MCC Rules for prepaid product
And User fills Dedupe Plan
And User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
And User fills Device Plan for "prepaid" "emv" card with no pin
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Business Mandatory Fields Screen for prepaid product with Corporate
And User fills Device Range section for prepaid product
And add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
And device has "normal" status
And user performs adjustment transaction
And currency setup for device
And user is on login page of cardholder portal
And cardholder signup with valid details
And fund transfer through MasterCard Money Send
Then verify MasterCard Money send fund transfer stauts
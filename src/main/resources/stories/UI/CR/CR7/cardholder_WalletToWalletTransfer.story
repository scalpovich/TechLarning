!-- auther: e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to do the transactions


Meta:
@StoryName CHP_CS
@SanityCards

Scenario: To Verify functionality of wallet to wallet transfer from mastercard interchange by emv card
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
When User fills Marketing Message Plan for prepaid product
When User fills Prepaid Statement Plan
When User fills MCC Rules for prepaid product
When User fills Dedupe Plan
When User fills Transaction Plan for prepaid product
When User fills Transaction Limit Plan for prepaid product
When User fills Document Checklist Screen for prepaid product
When User fills Device Joining and Membership Fee Plan for prepaid product
When User fills Device Event Based Fee Plan for prepaid product
When User fills Device Plan for "prepaid" "emv" card with no pin
When User fills Wallet Plan for prepaid product
When User fills Program section for prepaid product
When User fills Business Mandatory Fields Screen for prepaid product
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client
Then device has "normal" status
Given user is on login page of cardholder portal
Then card holder signup with valid details
When wallet to wallet fund transfer
Then verify wallet to wallet transfer fund transfer stauts
Given user is logged in institution
Then verify wallet to wallet transfer transaction amount




Scenario: To Verify functionality of wallet to wallet transfer from mastercard interchange by magnetic stripe card
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
When User fills Marketing Message Plan for prepaid product
When User fills Prepaid Statement Plan
When User fills MCC Rules for prepaid product
When User fills Dedupe Plan
When User fills Transaction Plan for prepaid product
When User fills Transaction Limit Plan for prepaid product
When User fills Document Checklist Screen for prepaid product
When User fills Device Joining and Membership Fee Plan for prepaid product
When User fills Device Event Based Fee Plan for prepaid product
When User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
When User fills Wallet Plan for prepaid product
When User fills Program section for prepaid product
When User fills Business Mandatory Fields Screen for prepaid product
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client
Then device has "normal" status
Given user is on login page of cardholder portal
Then card holder signup with valid details
When wallet to wallet fund transfer
Then verify wallet to wallet transfer fund transfer stauts
Given user is logged in institution
Then verify wallet to wallet transfer transaction amount
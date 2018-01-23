!-- auther: e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to do the transactions


Meta:
@StoryName CHP_CS
@SanityCards

Scenario: To check functionality of wallet fund transfer by emv card with program Corporate Travel Card - Multi Currency on cardholder portal
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
When fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When wallet to wallet fund transfer
Given user is logged in institution
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Corporate Travel Card - Multi Currency
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
When fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When wallet to wallet fund transfer
Given user is logged in institution
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Retail Travel Card - Multi Currency
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
When fills Wallet Plan for prepaid product and program Retail Travel Card - Multi Currency [2]
When User fills Program section for prepaid product and program Retail Travel Card - Multi Currency [2]
When User fills Business Mandatory Fields Screen for prepaid product with Individual
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Individual customer
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When wallet to wallet fund transfer
Given user is logged in institution
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Retail Travel Card - Multi Currency
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
When fills Wallet Plan for prepaid product and program Retail Travel Card - Multi Currency [2]
When User fills Program section for prepaid product and program Retail Travel Card - Multi Currency [2]
When User fills Business Mandatory Fields Screen for prepaid product with Individual
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Individual customer
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When wallet to wallet fund transfer
Given user is logged in institution
Then search with device in transaction screen and status for wallet to wallet transfer transaction
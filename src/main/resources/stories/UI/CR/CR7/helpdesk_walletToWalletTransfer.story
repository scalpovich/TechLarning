Narrative:
As a Cardhodler
I want to login into customer portal 
In order to do the wallet to wallet fund transfer


Meta:
@StoryName c_helpdesk_wallet_transfer
@csr_wtow_fundTransfer

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate Travel Card - Multi Currency
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
And User fills Business Mandatory Fields Screen for prepaid product with Corporate [1]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And device has "normal" status
And user performs adjustment transaction
And user assigns service code to program
And currency setup for device
And wallet to wallet transfer selected account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Corporate Travel Card - Multi Currency
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
And User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
And fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
And User fills Business Mandatory Fields Screen for prepaid product with Corporate [1]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And device has "normal" status
And user performs adjustment transaction
And user assigns service code to program
And currency setup for device
And wallet to wallet transfer selected account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Retail Travel Card - Multi Currency
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
And fills Wallet Plan for prepaid product and program Retail Travel Card - Multi Currency [2]
And User fills Program section for prepaid product and program Retail Travel Card - Multi Currency [2]
And User fills Business Mandatory Fields Screen for prepaid product with All [0]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Individual customer
And device has "normal" status
And user performs adjustment transaction
And user assigns service code to program
And currency setup for device
And wallet to wallet transfer selected account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Retail Travel Card - Multi Currency
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
And User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
And fills Wallet Plan for prepaid product and program Retail Travel Card - Multi Currency [2]
And User fills Program section for prepaid product and program Retail Travel Card - Multi Currency [2]
And User fills Business Mandatory Fields Screen for prepaid product with All [0]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Individual customer
And device has "normal" status
And user performs adjustment transaction
And user assigns service code to program
And currency setup for device
And wallet to wallet transfer selected account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Corporate General Purpose Card
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
And User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
And user fills Merchant Category Group
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Open Loop"
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Closed Loop"
And fills Program section for prepaid product and program Corporate General Purpose Card [8]
And User fills Business Mandatory Fields Screen for prepaid product with Corporate [1]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And device has "normal" status
And user get attached wallet details for device
And user assigns service code to program
And user performs adjustment transaction
And wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate General Purpose Card
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
And user fills Merchant Category Group
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Open Loop"
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Closed Loop"
And fills Program section for prepaid product and program Corporate General Purpose Card [8]
And User fills Business Mandatory Fields Screen for prepaid product with Corporate [1]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Corporate customer
And device has "normal" status
And user get attached wallet details for device
And user assigns service code to program
And user performs adjustment transaction
And wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with Retail General Purpose Card
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
And User fills Device Plan for "prepaid" "magnetic stripe" card with no pin
And user fills Merchant Category Group
And create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
And create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
And fills Program section for prepaid product and program Retail General Purpose Card [4]
And User fills Business Mandatory Fields Screen for prepaid product with All [0]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Individual customer
And device has "normal" status
And user get attached wallet details for device
And user assigns service code to program
And user performs adjustment transaction
And wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with Retail General Purpose Card
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
And user fills Merchant Category Group
And create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
And create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
And fills Program section for prepaid product and program Retail General Purpose Card [4]
And User fills Business Mandatory Fields Screen for prepaid product with All [0]
And User fills Device Range section for prepaid product
And add menus to access card holder portal
And user creates new device of prepaid type for new client of Individual customer
And device has "normal" status
And user get attached wallet details for device
And user assigns service code to program
And user performs adjustment transaction
And wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal
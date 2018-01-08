!-- auther: e076168
Narrative:
As a Cardhodler
I want to able to loing into customer portal 
In order to do the wallet to wallet transactions


Meta:
@StoryName c_helpdesk_wallet_transfer
@SanityCards

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate Travel Card - Multi Currency
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
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
When wallet to wallet transfer selected account
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
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
When wallet to wallet transfer selected account
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
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
When wallet to wallet transfer selected account
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
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
When wallet to wallet transfer selected account
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with program Corporate General Purpose Card
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
When user fills Merchant Category Group
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
When fills Program section for prepaid product and program Retail General Purpose Card [4]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate General Purpose Card
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
When user fills Merchant Category Group
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
When fills Program section for prepaid product and program Retail General Purpose Card [4]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
Then device has "normal" status
Then user get attached wallet details for device
Then user performs adjustment transaction
When wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by msr card with Retail General Purpose Card
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
When user fills Merchant Category Group
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
When fills Program section for prepaid product and program Retail General Purpose Card [4]
When User fills Business Mandatory Fields Screen for prepaid product with Individual
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Individual customer
Then device has "normal" status
Then user get attached wallet details for device
Then user performs adjustment transaction
When wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with Retail General Purpose Card
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
When user fills Merchant Category Group
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Retail General Purpose Card [4]" with usage "Closed Loop"
When fills Program section for prepaid product and program Retail General Purpose Card [4]
When User fills Business Mandatory Fields Screen for prepaid product with Individual
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Individual customer
Then device has "normal" status
Then user get attached wallet details for device
Then user performs adjustment transaction
When wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
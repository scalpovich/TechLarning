!-- auther: e076168
Narrative:
As a Cardhodler user
I want to able to loing into customer portal 
In order to create Remittance request


Meta:
@StoryName REMITTANCE_REQUEST
@SanityCards
@CR
@CR4
@all
@CR4_Remittance
Scenario:To Verify that perform Remittance Payout transaction with emv Corporate General Purpose Card
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
When create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Closed Loop"
When fills Program section for prepaid product and program Corporate General Purpose Card [8]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
Then device has "normal" status
Then user gets attached wallet details for device
Then user performs adjustment transaction
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When cardholder book the cash remittance
When cardholder cancel the cash remittance

Scenario:To Verify that perform Remittance Payout transaction with msr Corporate General Purpose Card
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
When create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Open Loop"
When create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Closed Loop"
When fills Program section for prepaid product and program Corporate General Purpose Card [8]
When User fills Business Mandatory Fields Screen for prepaid product with Corporate
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client of Corporate customer
Then device has "normal" status
Then user gets attached wallet details for device
Then user performs adjustment transaction
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When cardholder book the cash remittance
When cardholder cancel the cash remittance

Scenario:To Verify that perform Remittance Payout transaction with emv Retail General Purpose Card
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
Then user gets attached wallet details for device
Then user performs adjustment transaction
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When cardholder book the cash remittance
When cardholder cancel the cash remittance

Scenario:To Verify that perform Remittance Payout transaction with msr Retail General Purpose Card
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
Then user gets attached wallet details for device
Then user performs adjustment transaction
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When cardholder book the cash remittance
When cardholder cancel the cash remittance
ECOMM_PURCHASE transaction on debit virtual retail debit card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create virtual retail debit card for client

Meta:
@StoryName S198219
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on debit virtual retail debit card
Meta:
@TestId TC398504
Given user is logged in institution
And device range for program with device plan for "debit" "static virtual" card
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And a new device was created
When processes pre-production batch for debit
Then embossing file batch was generated in correct format
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal
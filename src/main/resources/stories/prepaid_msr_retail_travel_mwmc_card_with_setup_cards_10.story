Prepaid msr retail travel card multi currency with pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mc
@CRCardsWithAuthorizationCashAdvancedWithClearing

!-- Scenario: Setup multi-currency prepaid msr retail travel card and perfomr refund without pin authorization
!-- Given user is logged in institution
!-- When device range for program with device plan for "prepaid" "magnetic stripe" card
!-- Then user sign out from customer portal

Scenario:creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product and program Retail Travel Card - Multi Currency [2]
And User Primary Device fills New Program Retail Travel Card - Multi Currency [2] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
Then user sign out from customer portal


Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal


Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user setup device currency through helpdesk
And currency setup for prepaid device is done correctly and updated in wallet details tab
And user performs adjustment transaction with 500 amount
And user performs adjustment transaction for second wallet
Then user sign out from customer portal

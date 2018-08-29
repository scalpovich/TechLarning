Prepaid msr retail travel card multi currency with pin authorization

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_msr_retail_travel_mc
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Setup multi-currency prepaid msr retail travel card and perfomr refund without pin authorization
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card
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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

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

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed


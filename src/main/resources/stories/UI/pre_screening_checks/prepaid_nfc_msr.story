NFC-MSR Transaction

Narrative:
In order to verify NFC MSR Transaction 
As an issuer
I want to do NFC MSR Transaction 

Meta:
@StoryName p_msr_retail_gen_purpose

Scenario: Set up prepaid emv retail general purpose card
Given setting json values in excel for Prepaid
And user is logged in institution
And device range for program with device plan for "prepaid" "NFC Device - Mag Stripe" card without pin
And user sign out from customer portal

Scenario: prepaid msr retail general purpose card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_NFC_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
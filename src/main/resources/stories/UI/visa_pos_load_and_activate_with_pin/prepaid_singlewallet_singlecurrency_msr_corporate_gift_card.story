Prepaid swsc msr corporate gift pinless card : Visa Load and Activate With Pin

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Visa Load and Activate With Pin

Meta:
@StoryName SWSC_MSR_CGC_LOAD_ACTV_VTS_NPIN
@visa_rvmt_receiving_with_pin

Scenario: Set up prepaid swsc msr corporate gift pinless card and perform Visa Load and Activate With Pin
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" "Manual" activation code for card with pin for an interface
When user creates new device of prepaid type for new client
When device has "normal" status
When a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When device has "normal" status
When user activates device through helpdesk
Then connection to FINSim is established
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
When connection to VISA is established
When perform an LoadAndActivate_with_pin VISA transaction
When VISA test results are verified for LoadAndActivate_with_pin
!-- Then search Load and Activate authorization and verify Successful status
!-- And user sign out from customer portal
Then VISA simulator is closed
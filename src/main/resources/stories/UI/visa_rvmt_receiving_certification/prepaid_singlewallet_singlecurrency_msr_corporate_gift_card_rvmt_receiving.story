Prepaid swsc msr corporate gift pinless card : Visa RVMT Receiving Certification

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform RVMT Receiving through vts

Meta:
@StoryName SWSC_MSR_CGC_LOAD_ACTV_VTS_NPIN
@visa_rvmt_receiving

Scenario: Set up prepaid swsc msr corporate gift pinless card and perform Visa RVMT Receiving Certification
Meta:
@TestId
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" "Manual" activation code for card without pin for an interface
When user creates new device of prepaid type for new client
When device has "normal" status
When a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When device has "normal" status
When user activates device through helpdesk
When connection to VISA is established
When perform an Rvmt_Receiving_certification_1 VISA transaction
When VISA test results are verified for Rvmt_Receiving_certification_1
Then search Rvmt_Receiving authorization and verify Successful status
And user sign out from customer portal
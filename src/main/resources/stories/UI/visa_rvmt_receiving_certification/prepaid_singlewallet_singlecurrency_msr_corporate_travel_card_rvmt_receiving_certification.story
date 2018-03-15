Prepaid swsc msr corporate travel pinless card : Visa RVMT Receiving Certification

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform RVMT Receiving through vts

Meta:
@StoryName SWSC_MSR_CTC_LOAD_ACTV_VTS_NPIN
@visa_rvmt_receiving

Scenario: Set up prepaid swsc msr corporate travel pinless card and perform Visa RVMT Receiving Certification
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

Scenario: VISARVMT_Receiving_Certification_1
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_1 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_1
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

Scenario: VISARVMT_Receiving_Certification_2
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_2 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_2
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

Scenario: VISARVMT_Receiving_Certification_3
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_3 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_3
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

Scenario: VISARVMT_Receiving_Certification_4
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_4 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_4
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal


Scenario: VISARVMT_Receiving_Certification_5
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_5 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_5
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

Scenario: VISARVMT_Receiving_Certification_6
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_6 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_6
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

Scenario: VISARVMT_Receiving_Certification_7
Given connection to VISA is established
When perform an RVMT_Receiving_Certification_7 VISA transaction
Then VISA test results are verified for RVMT_Receiving_Certification_7
Given user is logged in institution
Then search Rvmt_Receiving authorization and verify Successful status
And user signs out from customer portal

!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Bulk device generation request for prepaid devices
So that multiple devices get created with different data conditions

Meta:
@BulkDeviceGenerationPrepaidCR
@StoryName S193816

Scenario: Scenario1 - Verify that the Users must be able to create bulk device production request from the system successfully for Visa Corp EMV
Meta:
@CR
@all
@BulkDeviceGenerationPrepaidCorpVisaEMV
@TCName TC264315_Embossing File Generation_VISA
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate General Purpose, Visa, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
And Pack Id should be generated as per the template configured
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then Expiry date should be calculated as per the flag configured at device plan
When user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
When user retrieves the device number from the query
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then pair devices should be generated for each of the processed Device and the paired device should be inactive state
And user verifies the Pre generated flag at device level should be set to Y once the device is created
Then user onboard the Device through Agent Portal and Activate through HelpDesk


Scenario: Scenario2 - Verify that the Users must be able to create bulk device production request from the system successfully for MC Corp EMV
Meta:
Lifecycle:
After:
Outcome: SUCCESS
@BulkDeviceGenerationPrepaidCorpVisaEMV
@TCName TC264315_Embossing File Generation_VISA
@sheetName S205014
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Activate Device
And user activates the device through HelpDesk
Then activation of registered device prepaid is successful and activation date is updated


Scenario: Scenario3 - Verify that the Users must be able to create bulk device production request from the system successfully for Visa Retail EMV
Meta:
@CR
@all
@BulkDeviceGenerationPrepaidRetailVisaEMV
@TCName TC264315_Embossing File Generation_VISA
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail General Purpose, Visa, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
And Pack Id should be generated as per the template configured
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then Expiry date should be calculated as per the flag configured at device plan
When user creates a paired device plan and configures the device range for Retail General Purpose, Visa, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
When user retrieves the device number from the query
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then pair devices should be generated for each of the processed Device and the paired device should be inactive state
And user verifies the Pre generated flag at device level should be set to Y once the device is created
Then user onboard the Device through Agent Portal and Activate through HelpDesk


Scenario: Scenario4 - Verify that the Users must be able to create bulk device production request from the system successfully for Visa Retail EMV
Meta:
Lifecycle:
After:
Outcome: SUCCESS
@BulkDeviceGenerationPrepaidRetailVisaEMV
@TCName TC264315_Embossing File Generation_VISA
@sheetName S205014
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Activate Device
And user activates the device through HelpDesk
Then activation of registered device prepaid is successful and activation date is updated
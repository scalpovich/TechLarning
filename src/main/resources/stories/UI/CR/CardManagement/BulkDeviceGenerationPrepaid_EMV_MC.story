!-- @author: E060549
Narrative:
As a(n)  Customer portal user 
I want to  create/define a Bulk device generation request for prepaid devices
So that multiple devices get created with different data conditions

Meta:
@StoryName S193816
@BulkDeviceGenerationPrepaidCR


Scenario:1 - Verify that the Users must be able to create bulk device production request from the system successfully for MC Corp EMV
Meta:
@CR
@all
@BulkDeviceGenerationPrepaidCorpMCEMV
@TCName TC264315_Embossing File Generation
@sheetName S205014

Given login to portal as existing bank as a Customeruser
When user configures the device range for Corporate General Purpose, Mastercard, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user check for the  Bulk Device Generation batch success status for SYSTEM INTERNAL PROCESSING batch
When user runs the pre production batch for product Prepaid
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
And Pack Id should be generated as per the template configured
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then Expiry date should be calculated as per the flag configured at device plan
When user creates a paired device plan and configures the device range for Corporate General Purpose, Mastercard, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
When user retrieves the device number from the query
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then pair devices should be generated for each of the processed Device and the paired device should be inactive state
Then user verifies the Pre generated flag at device level should be set to Y once the device created
Then user onboard the Device through Agent Portal and Activate through HelpDesk

Scenario:2 - Verify that the Users must be able to create bulk device production request from the system successfully for MC Corp EMV
Meta:
@BulkDeviceGenerationPrepaidCorpMCEMV
@TCName TC264315_Embossing File Generation
@sheetName S205014
Given user is logged in institution
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Activate Device
And user activates the device through HelpDesk
Then activation of registered device prepaid is successful and activation date is updated

Scenario:3 - Verify that the Users must be able to create bulk device production request from the system successfully for MC Retail EMV
Meta:
@CR
@all
@BulkDeviceGenerationPrepaidRetailMCEMV
@TCName TC264315_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user configures the device range for Retail General Purpose, Mastercard, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user check for the  Bulk Device Generation batch success status for SYSTEM INTERNAL PROCESSING batch
When user runs the pre production batch for product Prepaid
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
And Pack Id should be generated as per the template configured
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then Expiry date should be calculated as per the flag configured at device plan
When user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, EMV
When user creates a bulk device request for product Prepaid
When user runs the bulk device generation batch for product Prepaid
When user runs the pre production batch for product Prepaid
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user processes all the devices and runs the device production batch for product Prepaid
When user retrieves the device number from the query
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
Then pair devices should be generated for each of the processed Device and the paired device should be inactive state
And user verifies the Pre generated flag at device level should be set to Y once the device created
Then user onboard the Device through Agent Portal and Activate through HelpDesk

Scenario:4 - Verify that the Users must be able to create bulk device production request from the system successfully for MC Retail EMV
Meta:
@BulkDeviceGenerationPrepaidRetailMCEMV
@TCName TC264315_Embossing File Generation
@sheetName S205014
Given user is logged in institution
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Activate Device
And user activates the device through HelpDesk
Then activation of registered device prepaid is successful and activation date is updated
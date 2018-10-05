!-- authors: Trupti G and Nidhi S   
Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:  
@Regression
@UI 
@All
@HelpdeskEvents
 
Scenario: Creation of debit device
Meta:
@MIDeviceCreationdebitHelpdesk
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372
Given login to portal as existing bank as a user
When user creates a new Debitdevice with the required configuration
Then device should get generated with the device number


!-- Block Event  [108]
Scenario: Helpdesk Block event 
Meta: 
@TCName TC_BlockEvent_CARD0P0023
@sheetName HelpDesk
@CARD0P0023

Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Block
Then User edit the Block Device service Code with note Blocking Device

Scenario: Helpdesk UnBlock event 
Meta: 
@TCName TC_UnBlockEvent_CARD0P0024
@sheetName HelpDesk
@CARD0P0024

Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as UnBlock
Then User edit the Unblock Device service Code with note UnBlocking Device

!-- Done
Scenario: Helpdesk Mailing Address Preference Request [107]
Meta: 
@TCName TC_Mailing_Address_Preference
@sheetName HelpDesk
@CARD0P0039

Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Mailing Address
Then User edit the Mailing Address service Code with email indicator to Permanent and note to update Mailing address
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Mailing Address
Then User edit the Mailing Address service Code with email indicator to Office and note to update Mailing address


!-- done 
Scenario: Helpdesk Redemption Inquiry 
Meta: 
@TCName TC_Redemption Inquiry _LOYT0P0001
@sheetName HelpDesk
@LOYT0P0001

Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Redemption Inquiry
Then User edit the Redemption Inquiry service Code with note Redemption Inquiry Automation



Scenario: Helpdesk Stop List Event
Meta: 
@TCName TC_Stop_list_Device_CARD0P0020
@sheetName HelpDesk
@CARD0P0020
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Stop list
Then User edit the Stop list service Code for Card Lost with Lost
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Withdraw Device
Then User edit the Withdraw list service Code for Found with Found

Scenario: Helpdesk Withdraw Device from Stop-list Event
Meta: 
@TCName TC_Withrawal_Stop_list_Device_CARD0P0021
@sheetName HelpDesk
@CARD0P0021
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as Withdraw Device
Then User edit the Withdraw list service Code for Found with Found

Scenario: Helpdesk International Use Allow Event
Meta: 
@TCName TC_International_Use_Allow_CARD0P0029
@sheetName HelpDesk
@CARD0P0029
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type Prepaid
And user select the service code as International Use
Then User edit the International Use service Code of operation Activate for Activation type Life Long with note Activated
 
!-- Activate Device  [108] 
Scenario: To check that an email is sent to the registered email on device activation
Meta:
@TCName TC_DeviceActivation
@sheetName HelpDesk
@ActivateDevice
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Activate Device
And user activates the device through HelpDesk
Then verify an event is generated on device activation through Helpdesk
 
!-- Email/SMS Alert Change Request [477]
Scenario: To check that an email is sent to the registered email on activating the alerts through email
Meta:
@TCName TC_AlertEmailActive
@sheetName HelpDesk
@AlertEmailActive
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Email/SMS Alert Change
And user select the email alerts as Active
Then verify an event is generated on device activation through Helpdesk


Scenario: To check that an email is sent to the registered email on deactivating the alerts through email
Meta:
@TCName TC_AlertEmailDeactive
@sheetName HelpDesk
@AlertEmailDeactive
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Email/SMS Alert Change
And user select the email alerts as Deactive
Then verify an event is generated on device activation through Helpdesk


Scenario: To check that an email is sent to the registered email on activating the alerts through SMS
Meta:
@TCName TC_AlertSMSActive
@sheetName HelpDesk
@AlertSMSActive
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Email/SMS Alert Change
And user select the sms alerts as Active
Then verify an event is generated on device activation through Helpdesk


Scenario: To check that an email is sent to the registered email on activating the alerts through SMS
Meta:
@TCName TC_AlertSMSDeactive
@sheetName HelpDesk
@AlertSMSDeactive
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Email/SMS Alert Change
And user select the sms alerts as Deactive
Then verify an event is generated on device activation through Helpdesk

!-- Link Card Query [203]
Scenario: To check that an email is sent to the registered email on linking a query about the card through helpdesk
Meta:
@TCName TC_LinkCardQuery
@sheetName HelpDesk
@LinkCardQuery
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Link Card Query
And user links a card query through HelpDesk
Then verify an event is generated on device activation through Helpdesk

!-- Do Not Call Register Request [106]
Scenario: To check that an email is sent to the registered email on adding the card into the Do Not Call Register
Meta:
@TCName TC_DoNotCallRegisterRequest
@sheetName HelpDesk
@DoNotCallRegisterRequest
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Do Not Call Reg
And user add the card into the Do Not Call Register through HelpDesk
Then verify an event is generated on device activation through Helpdesk

!-- Add Call Notes [456]
Scenario: To check that an email is sent to the registered email on adding call notes through HelpDesk
Meta:
@TCName TC_AddCallNotes
@sheetName HelpDesk
@AddCallNotes
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Add Call Notes
And user adds call notes through HelpDesk
Then verify an event is generated on device activation through Helpdesk

!-- Add-on Card Request [102]
Scenario: To check that an email is sent to the registered email on adding call notes through HelpDesk
Meta:
@TCName TC_AddOnCardRequest
@sheetName HelpDesk
@AddOnCardRequest
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Add On Card
And user requests for an Add On Card through HelpDesk
Then verify an event is generated on device activation through Helpdesk

!-- Change Address Request [104]
Scenario: To check that an email is sent to the registered email for Change Address Request through HelpDesk
Meta:
@TCName TC_ChangeAddressRequest
@sheetName HelpDesk
@ChangeAddressRequest
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as Change Address Request
And user requests for an address change through HelpDesk
Then verify an event is generated on device activation through Helpdesk

!-- E-commerce Activation/Deactivation [304]

Scenario: To check that an email is sent to the registered email on activating immediately for n hours e-commerce through HelpDesk
Meta:
@TCName TC_ActivateECommImmediate
@sheetName HelpDesk
@ActivateECommImmediate
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as E-Commerce Activation
And user requests to activate for nhours for ecommerce
Then verify an event is generated on device activation through Helpdesk

Scenario: To check that an email is sent to the registered email on activating for period e-commerce through HelpDesk
Meta:
@TCName TC_ActivateECommForPeriod
@sheetName HelpDesk
@ActivateECommPeriod
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as E-Commerce Activation
And user requests to activate for ActivationPeriod for ecommerce
Then verify an event is generated on device activation through Helpdesk

Scenario: To check that an email is sent to the registered email on activating life long e-commerce through HelpDesk
Meta:
@TCName TC_ActivateECommLifeLong
@sheetName HelpDesk
@ActivateECommLifeLong
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as E-Commerce Activation
And user requests to activate for lifeLong for ecommerce
Then verify an event is generated on device activation through Helpdesk


Scenario: To check that an email is sent to the registered email on deactivating e-commerce through HelpDesk
Meta:
@TCName TC_DeactivateEComm
@sheetName HelpDesk
@DeactivateEComm
Given login to portal as existing bank as a user
When user navigates to General in Helpdesk
And user search for device on search screen for product type prepaid
And user select the service code as E-Commerce Activation
And user requests to deactivates for e commerce
Then verify an event is generated on device activation through Helpdesk
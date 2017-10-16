Narrative:
As a(n)  Customer portal user 
I want to configure the system with Different Events and notifcations
So that Events & notification should get trigerred while performing different Issuing activities


Meta:
@MIEvents

Scenario: Verfiy various prepaid event gets mapped with event templates for issuing product 
Meta:
@MIEventsMapping
@TCName TC01_Events mapping with templates
@sheetName Events Configuration
@1
Given login to existing bank as a user
When user map different prepaid events with event templates for prepaid product
Then all events gets configured for all issuing events


Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@MIDeviceCreationprepaid
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372
Given login to existing bank as a user
When user creates a new Prepaiddevice with the required configuration
Then device should get generated with the device number
Narrative:
As a(n)  Customer portal user 
I want to configure the system with Rupay interchange
So that new device can be created with the rupay interchange type


Meta:
@MIDeviceCreation

Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@MIDeviceCreationdebit
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372
Given login to portal as existing bank as a user
When user creates a new Debitdevice with the required configuration
And Create HSM Device Keys
And Create HSM Network Keys
And Create MDK keys
Then device should get generated with the device number


Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Meta:
@MIDeviceCreationprepaid
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372
Given login to portal as existing bank as a user
When user creates a new Prepaiddevice with the required configuration
And Create HSM Device Keys
And Create HSM Network Keys
And Create MDK keys
Then device should get generated with the device number
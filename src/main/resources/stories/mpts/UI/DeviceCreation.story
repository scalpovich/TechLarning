Narrative:
As a(n)  Customer portal user 
I want to configure the system with Rupay interchange
So that new device can be created with the rupay interchange type


Meta:
@TC264306
@MIDeviceCreation
@TCName TC01_MI-ISS-Embossing File-Additional Parameters in Embossing File Template
@sheetName S181372


Scenario: Embossing file can be generated with additional parameters and attach it to device plan
Given login to existing bank as a Customerportaluser
When user creates a new Debitdevice with the required configuration
Then device should get generated with the device number
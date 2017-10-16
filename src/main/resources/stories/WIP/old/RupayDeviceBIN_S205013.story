Narrative:
As a(n)  customer portal user
I want that the user should be able to configure the Device Bin for Rupay Network
So that rupay bins can be defined in the system

Meta:
@all
@UI
@R6releaseAutomation

Scenario: RPY005 -- RuPay Device Bin
Meta:
@Regression
@Smoke
@TC264530
@RupayDeviceBin
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to existing bank as a user
When user access the device bin screen
Then the user should be able to configure the bin for the newly added Rupay Network
Narrative:
As a(n)  Processor
I want to to enable the rupay network for the institution
So that Embossing files can the rupay network is enable to the particular institution so that they can configure rupay network under there institution to issue and process rupay cards and transactions

Meta:
@all
@UI
@R6releaseAutomation

Scenario: Rupay Bank Network Membership Configuration for Add
Meta:
@Regression
@Smoke
@TC264485
@RuparBankNetworkConf
@TCName TC264211_Rupay Interchange Card Type options validation
@sheetName S205000
Given login to existing bank as a user
When necessary network is added
And user tries to access this record on the network membership configuration screen
Then he must be allowed to add the rupay network from the screen

Scenario: Rupay Bank Network Membership Configuration for Edit
Meta:
@Regression
@Smoke
@TC264486
@RuparBankNetworkConf
@TCName TC264211_Rupay Interchange Card Type options validation
@sheetName S205000
Given login to existing bank as a user
When user tries to edit this record on the network membership configuration screen
Then he must be allowed to edit the rupay network from the screen

Scenario: Rupay Bank Network Membership Configuration for Delete
Meta:
@Regression
@Smoke
@TC264487
@TCName TC264211_Rupay Interchange Card Type options validation
@sheetName S205000
Given login to existing bank as a user
When user tries to delete this record on the network membership configuration screen
Then he must be allowed to delete the already added rupay network from the screen in case there are no programs and transactions configured for that network

Scenario: Rupay Bank Network Membership Configuration for Download
Meta:
@Regression
@Smoke
@TC268371
@TCName TC264211_Rupay Interchange Card Type options validation
@sheetName S205000
Given login to existing bank as a user
When user tries to download the lists of Bank Network
Then the user must be able to download all the Bank Network configured in the excel file format (CSV)

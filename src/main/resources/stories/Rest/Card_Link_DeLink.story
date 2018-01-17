Narrative: afslkfj
As a User
I want to Execute multiple API
In order to Validate json respose

Meta:
@LINK_DLINK_API
@storyType API

Scenario:TO Check Card Link API
Meta:
@CardLinkPositive
Given user update Card_Link.json with below Attributes:
|AttributesToUpdate|
|deviceNumber=GetDevice|
|walletNumber=GenrateDefaultWalletNum|
|defaultWallet=Y|
|accountType=10|
When user send put request having parametr as link with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|messageText=Request processed successfully.|
Then Validate Status code as 201


Then user update Card_Link.json with below Attributes:
|AttributesToUpdate|
|deviceNumber=GetDeviceDOM|
|walletNumber=GenrateCustomWalletNum|
|defaultWallet=N|
|accountType=10|
Then user send put request having parametr as link with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|messageText=Request processed successfully.|

Then Validate Status code as 201

Then check link status

Then user update Card_DeLink.json with below Attributes:
|AttributesToUpdate|
|deviceNumber=GetDeviceDOM|
|walletNumber=GetDefaultWalletDOM|
|delinkingStatus=Y|
|newDefaultWallet=GetCustomWalletDOM|
Then user send put request having parametr as delink with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|messageText=Request processed successfully.|

Then Validate Status code as 201

Then check Delink status

Then user update Card_DeLink.json with below Attributes:
|AttributesToUpdate|
|deviceNumber=GetDeviceDOM|
|walletNumber=GetDefaultWalletDOM|
|delinkingStatus=N|
|newDefaultWallet=GetCustomWalletDOM|
Then user send put request having parametr as delink with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|messageText=Delinking status received is invalid.|
Then Validate Status code as 400
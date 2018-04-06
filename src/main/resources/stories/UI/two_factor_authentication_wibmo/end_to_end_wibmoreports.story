Narrative:
As an user I need to have the Privilege rights access for Web API detailed Reports in the Customer Portal.

Meta:
@StoryName wibmo_IsEligible

Scenario:  TO Check Card Eligibility With Valid Fields
Meta:
@storyType API
@datasheet wibmo_IsEligible
Given user creates json request
When user sends post request at isEligible
Then Validate Response for below Attributes:
|AttributesToValidate|
|isEligible=true|
Then Validate Status code as 200
And store issuerSessionId for furtheruse

Scenario:  TO Check fetch avilable aliases With Valid Fields
Meta:
@datasheet wibmo_fetch_Available_Aliases
Given user creates json request
When user sends post request at fetchAvailableAliases
Then Validate Response for below Attributes:
|AttributesToValidate|
|availableAliases[0].aliasType=SMS|
|availableAliases[1].aliasType=EMAIL|
|availableAliases[0].displayAliasType=mobile|
|availableAliases[1].displayAliasType=mail|
Then Validate Status code as 200
And store issuerSessionId for furtheruse

Scenario:  TO Check sendOtp Call with Valid Fields
Meta:
@datasheet wibmo_send_otp
Given user creates json request
When user sends post request at sendOtp
Then Validate Response for below Attributes:
|AttributesToValidate|
|issuerSessionId=GET_ISSUER_SESSION_ID|
Then Validate Status code as 200

Scenario: validate two factor authentication at processing center
Meta:
@TCName TC264306_Embossing File Generation
@testDataFileName testdata
@sheetName S205014
@wibmo_api_report
Given login to portal as existing bank as a Customeruser
When user generates web api details PDF report for 328-3-D Secure Information Report
Then report should get generated
And verify the alert is generated succesfully for 3D Secure OTP Generation SMS

Scenario:  TO Check sendOtp Call with Valid Fields
Meta:
@datasheet wibmo_send_otp_email
Given user creates json request
When user sends post request at sendOtp
Then Validate Response for below Attributes:
|AttributesToValidate|
|issuerSessionId=GET_ISSUER_SESSION_ID|
Then Validate Status code as 200

Scenario: validate two factor authentication at processing center
Meta:
@TCName TC264306_Embossing File Generation
@testDataFileName testdata
@sheetName S205014
@wibmo_api_report
Given login to portal as existing bank as a Customeruser
When user generates web api details PDF report for 328-3-D Secure Information Report
Then report should get generated
And verify the alert is generated succesfully for 3D Secure OTP Generation Email

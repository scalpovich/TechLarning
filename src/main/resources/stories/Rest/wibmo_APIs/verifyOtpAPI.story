Narrative:
As a processor
I want to integrate with Adaptive Authentication for eCommerce 3DSecure product
So that our customers can experience the benefits of 3DSecure (SecureCode, Identity Check, Verified By VISA) such as risk reduction, cardholder authentication, and interchange protection for e-commerce transactions made by cardholders.

Meta:
@StoryName IsEligiable
@storyType API		 
Scenario:  TO Check Card Eligibility With Valid Fields
Meta:
@storyType API
@datasheet IsEligiable
Given user create json request
When user send post request at isEligible
Then Validate Response for below Attributes:
|AttributesToValidate|
|isEligible=true| 
And store issuerSessionId for furtheruse

Scenario:  TO Check fetch avilable aliases With Valid Fields
Meta:
@datasheet fetch_Available_Aliases
Given user create json request
When user send post request at fetchAvailableAliases
Then Validate Response for below Attributes:
|AttributesToValidate|
|availableAliases[0].aliasType=SMS|
|availableAliases[1].aliasType=EMAIL|
|availableAliases[0].displayAliasType=mobile|
|availableAliases[1].displayAliasType=mail|
And store issuerSessionId for furtheruse

Scenario:  TO Check verifyOtp Call with Valid Fields
Meta:
@datasheet verifyOtp
Given user create json request
When user send post request at verifyOtp
Then Validate Response for below Attributes:
|AttributesToValidate|
|issuerSessionId=GET_ISSUER_SESSION_ID|


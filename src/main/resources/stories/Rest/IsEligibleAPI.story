Narrative:
As a processor
I want to integrate with RSA Adaptive Authentication for eCommerce 3DSecure product
So that our customers can experience the benefits of 3DSecure (SecureCode, Identity Check, Verified By VISA) such as risk reduction, cardholder authentication, and interchange protection for e-commerce transactions made by cardholders.

Meta:
@StoryName IsEligiable
		 
Scenario:  TO Check Card Eligibility With Valid Fields
Meta:
@storyType API
@datasheet IsEligiable
Given user update isEligibleRequest.json file
When user send post request at isEligible
Then Validate Response for below Attributes:
|AttributesToValidate|
|isEligible=false|	 
Then store issuerSessionId for furtheruse

Scenario:  TO Check fetch avilable aliases With Valid Fields
Meta:
@datasheet fetch_Available_Aliases
Given user update fetchAvailableDevices_Request.json file
When user send post request at fetchAvailableAliases
Then Validate Response for below Attributes:
|AttributesToValidate|
|fetchAliasesValidResponse.availableOtpDevices=jsonarray|
Then store issuerSessionId for furtheruse
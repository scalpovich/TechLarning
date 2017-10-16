Narrative:
As a processor
I want to integrate with RSA’s Adaptive Authentication for eCommerce 3DSecure product
So that our customers can experience the benefits of 3DSecure (SecureCode, Identity Check, Verified By VISA) such as risk reduction, cardholder authentication, and interchange protection for e-commerce transactions made by cardholders.

Meta:
@CardEligibilityAPI
@storyType API		
		 
Scenario:  TO Check Card Eligibility With Valid Fields
Meta:
@CardEligibilityValid

Given user update isEligibleRequest.json with below Attributes:
|AttributesToUpdate|
|sessionId=12345678901234|
|pan=1234567890123456|
|timeStamp=2017-05-25T02:50:59|
When user send post request with updateded attributes
Then Validate Response for below Attributes:
|AttributesToValidate|
|eligibleValidResponse.isEligible=true|	 
Then store eligibleValidResponse.transactionId for fetchAvailableDevicesAPI

Scenario:  TO Check Card Eligibility With inValid Fields
Meta:
@CardEligibilityInValid

Given user update isEligibleRequest.json with <field>
When user send post request
Then Validate Response for <validate>
Examples:
|field|validate|
|sessionId=NA|error=errormsg|
|pan=NA|error=errormsg|
|timeStamp=NA|error=errormsg|
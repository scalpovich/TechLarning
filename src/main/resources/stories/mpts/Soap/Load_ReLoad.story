Narrative: 
As a User
I want to do Load Reload 
In order to check API response


Scenario: To verify an error code and error description for rejected request is unique
Meta:
@TCName TC231169_VerifyErroCodeNDescriptionForRejectedReuest
@sheetName S181372
@S181553 
@TC231169
@TC231169_VerifyErroCodeNDescriptionForRejectedReuest 

Given login to existing bank as a Customerportaluser
When User Delete all institution currency
Then I have a valid web service request loginRequest.xml
And I send the request
Then I need to save sessionKey for future steps

Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|
When I have a valid web service request Load_Reload.xml
Then I update xml for below tags: 
|tag|value |  
|txnCurrency|356| 
Then I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Meta:
@TC231161_VerifyErroCodeNDescriptionForSuccessfullReuest 
Scenario: To verify Load API request is successful configured currencies. 

Given login to existing bank as a Customerportaluser
When User set the institution INR [356] 
When User set the institution USD [840]
Then I have a valid web service request loginRequest.xml
And I send the request
Then I need to save sessionKey for future steps

Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|
When I have a valid web service request Load_Reload.xml
Then I update xml for below tags: 
|tag|value |  
|txnCurrency|356| 
Then I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Meta:
@TC231164
@TC231164_VerifyErroCodeNDescriptionForRejectedReuest 
Scenario: To verify Load API request is rejected if that currency is not configured.

Given login to existing bank as a Customerportaluser
When User Delete the institution currency INR [356]
 
Then I have a valid web service request loginRequest.xml
And I send the request
Then I need to save sessionKey for future steps

Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|
When I have a valid web service request Load_Reload.xml
Then I update xml for below tags: 
|tag|value |  
|txnCurrency|356| 
Then I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|-1|
|errorDesc|Failed|


 

 




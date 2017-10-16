Narrative:
As a Admin User
I want to go to Agent Portal and check validation of Mobile Number and Email ID while creating Admin users

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205651
@S205666
@AdminSingleInstitution
@Centaurus
					 
Scenario: Login to MPTS Agent Portal Application 
Meta:
@editUser
Given user login to agent portal with userName and password
When user selects the language
Then user should be in the home page and check the institution

Examples:
|userName|password|language|institution|
|AdminUser1|AdminPassword1|en|Institution1|



Scenario: Verificaiton of MobileNumber's uniqueness for Admin User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provides RoleID,UserID,UserName
And user enters Address,Country,PostalCode,PreferredLanguage,ISDCode
And user enters existing EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|654321-ADMIN [654321-Admin Role]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|Autotest@gmail.com|en|IND [+91]|UniqueMobile|User creation successful|

Scenario: Verificaiton of MobileNumber's uniqueness for Edit Admin User 
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Edit link
And user enters UserID and click on search button
And user clicks on record and click on modify button
Then user checks if EmailId and MobileNumber are mandatory
And user enters existing EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|UserID|EmailId|MobileNumber|Message|
|PreviousUserID|Autotest@gmail.com|UniqueMobile|User details updated successfully|


Scenario: Verificaiton of EmailID's uniqueness for Admin User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provides RoleID,UserID,UserName
And user enters Address,Country,PostalCode,PreferredLanguage,ISDCode
And user enters unique EmailId and existing MobileNumber 
And user clicks on create button
And user should get the error Message

Examples:
|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|654321-ADMIN [654321-Admin Role]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|9000000001|Mobile number should be unique.Entered mobile number is already registered against other User.|


Scenario: Verificaiton of EmailID's uniqueness for Edit Admin User
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Edit link
And user enters UserID and click on search button
And user clicks on record and click on modify button
Then user checks if EmailId and MobileNumber are mandatory
And user enters unique EmailId and existing MobileNumber
And user clicks on create button
And user should get the error Message

Examples:
|UserID|EmailId|MobileNumber|Message|
||UniqueEmail|9000000001|Mobile number should be unique.Entered mobile number is already registered against other User.|


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Admin User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provides RoleID,UserID,UserName
And user enters Address,Country,PostalCode,PreferredLanguage,ISDCode
And user enters unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|654321-ADMIN [654321-Admin Role]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|UniqueMobile|User creation successful|

Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Edit Admin User
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Admin User Edit link
And user enters UserID and click on search button
And user clicks on record and click on modify button
Then user checks if EmailId and MobileNumber are mandatory
And user enters unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|UserID|EmailId|MobileNumber|Message|
|PreviousUserID|UniqueEmail|UniqueMobile|User details updated successfully|


Scenario: Logout from MPTS Agent Portal Application 
Meta:
@Regression
Then user logouts from agent portal

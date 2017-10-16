Narrative:
As a Admin User
I want to go to Agent Portal and check validation of Mobile Number and 
Email ID while creating Admin users for two different Institutions

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205651
@S205666
@AdminTwoInstitution
@Centaurus

					 
Scenario: Login to MPTS Agent Portal Application with Admin Credentials of first Institution
Meta:
@Regression
Given user login to agent portal with userName and password
When user selects the language
Then user should be in the home page and check the institution

Examples:
|userName|password|language|institution|
|AdminUser1|AdminPassword1|en|Institution1|


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Admin User Creation in first Institution
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

Scenario: Logout from MPTS Agent Portal Application for First Institution
Meta:
@Regression
Then user logouts from agent portal





Scenario: Login to MPTS Agent Portal Application with Admin Credentials of second Institution
Meta:
@Regression
Given user login to agent portal with userName and password
When user selects the language
Then user should be in the home page and check the institution

Examples:
|userName|password|language|institution|
|AdminUser2|AdminPassword2|en|Institution2|


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Admin User Creation in second Institution
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
|772273-ADMIN [772273-Admin Role]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|PreviousEmail|en|IND [+91]|PreviousMobile|User creation successful|


Scenario: Logout from MPTS Agent Portal Application for Second Institution
Meta:
@Regression
Then user logouts from agent portal


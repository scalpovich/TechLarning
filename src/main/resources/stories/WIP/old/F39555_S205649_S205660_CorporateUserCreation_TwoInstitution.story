Narrative:
As a Admin User
I want to go to Agent Portal and check validation of Mobile Number and 
Email ID while creating Corporate users for two different Institutions

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205649
@S205660
@CorporateTwoInstitution
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


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Corporate User Creation in first Institution
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Corporate User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Corporate User's ParentID,RoleID,UserID and UserName
And user enters Corporate User's Address,Country,PostalCode,PreferredLanguage and ISDCode
And user enters Corporate User's unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message


Examples:
|ParentID|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|Pinwheel [65432117172000001]|CorpRole [Role for corporate]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|UniqueMobile|User creation successful|


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


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Corporate User Creation in Second Institution
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Corporate User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Corporate User's ParentID,RoleID,UserID and UserName
And user enters Corporate User's Address,Country,PostalCode,PreferredLanguage and ISDCode
And user enters Corporate User's unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|ParentID|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|Mastercard [77227317172000001]|SBCorporRole [SBCorporRoleDes]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|PreviousEmail|en|IND [+91]|PreviousMobile|User creation successful|


Scenario: Logout from MPTS Agent Portal Application for Second Institution
Meta:
@Regression
Then user logouts from agent portal


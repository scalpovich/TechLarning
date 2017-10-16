Narrative:
As a Agent User
I want to go to Agent Portal and check validation of Mobile Number and Email ID while creating Agent users

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205664
@S205647
@AgentSingleInstitution
@Centaurus

					 
Scenario: Login to MPTS Agent Portal Application 
Meta:
@Regression
Given user login to agent portal with userName and password
When user selects the language
Then user should be in the home page and check the institution

Examples:
|userName|password|language|institution|
|AdminUser1|AdminPassword1|en|Institution1|



Scenario: Verificaiton of MobileNumber's uniqueness for Agent User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Agent User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Agent ParentID,RoleID,UserID,UserName,TrnPassword
And user enters Addres,Country,PostalCode,PreferredLanguage,ISDCode for Agent user
And user enters existing EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|ParentID|RoleID|UserID|UserName|TrnPassword|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|AgentPinwheel [Agent01]|AgentRole [Role for agent]|UniqueUserID|AutoUserName|mAster@123|AutoAddress|SPAIN [724]|411006|Autotest@gmail.com|en|IND [+91]|UniqueMobile|User creation successful|



Scenario: Verificaiton of EmailID's uniqueness for Agent User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Agent User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Agent ParentID,RoleID,UserID,UserName,TrnPassword
And user enters Addres,Country,PostalCode,PreferredLanguage,ISDCode for Agent user
And user enters unique EmailId and existing MobileNumber 
And user clicks on create button
And user should get the error Message

Examples:
|ParentID|RoleID|UserID|UserName|TrnPassword|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|AgentPinwheel [Agent01]|AgentRole [Role for agent]|UniqueUserID|AutoUserName|mAster@123|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|9000000001|Mobile number should be unique.Entered mobile number is already registered against other User.|



Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Agent User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Agent User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Agent ParentID,RoleID,UserID,UserName,TrnPassword
And user enters Addres,Country,PostalCode,PreferredLanguage,ISDCode for Agent user
And user enters unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|ParentID|RoleID|UserID|UserName|TrnPassword|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|AgentPinwheel [Agent01]|AgentRole [Role for agent]|UniqueUserID|AutoUserName|mAster@123|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|UniqueMobile|User creation successful|

Scenario: Logout from MPTS Agent Portal Application 
Meta:
@Regression
Then user logouts from agent portal

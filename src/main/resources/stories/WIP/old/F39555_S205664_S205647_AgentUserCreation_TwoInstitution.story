Narrative:
As a Agent User
I want to go to Agent Portal and check validation of Mobile Number and 
Email ID while creating Agent users for two different Institutions

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205664
@S205647
@AgentTwoInstitution
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


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Agent User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Agent User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Agent ParentID,RoleID,UserID,UserName,TrnPassword
And user enters Agent Address,Country,PostalCode,PreferredLanguage,ISDCode
And user enters Agent unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message


Examples:
|ParentID|RoleID|UserID|UserName|TrnPassword|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|AgentPinwheel [Agent01]|AgentRole [Role for agent]|UniqueUserID|AutoUserName|mAster@123|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|UniqueMobile|User creation successful|

Scenario: Logout from MPTS Agent Portal Application for First Institution
Meta:
@Regression
Then user logouts from agent portal




Scenario: Again Login to MPTS Agent Portal Application 
Meta:
@Regression
Given user login to agent portal with userName and password
When user selects the language
Then user should be in the home page and check the institution

Examples:
|userName|password|language|institution|
|AdminUser2|AdminPassword2|en|Institution2|


Scenario: Again Verificaiton of both EmailID and MobileNumber's uniqueness for Agent User Creation
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Agent User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Agent ParentID,RoleID,UserID,UserName,TrnPassword
And user enters Agent Address,Country,PostalCode,PreferredLanguage,ISDCode
And user enters Agent unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message

Examples:
|ParentID|RoleID|UserID|UserName|TrnPassword|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|SBAgentName [SBAgent]|SBAgentRole [SBAgentRoleDes]|UniqueUserID|AutoUserName|mAster@123|AutoAddress|SPAIN [724]|411006|PreviousEmail|en|IND [+91]|PreviousMobile|User creation successful|


Scenario: Logout from MPTS Agent Portal Application for Second Institution
Meta:
@Regression
Then user logouts from agent portal


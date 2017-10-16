Narrative:
As a Admin User
I want to go to Agent Portal and check validation of Mobile Number and 
Email ID while creating Branch users for two different Institutions

Meta:
@all
@UI
@R6-Iteration-2
@F39555
@S205644
@S205645
@BranchTwoInstitution
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


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Branch User Creation in first Institution
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Branch User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Branch User's ParentID,RoleID,UserID and UserName
And user enters Branch User's Address,Country,PostalCode,PreferredLanguage and ISDCode
And user enters Branch User's unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message


Examples:
|ParentID|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|branchEntity [BranchEn]|BranchRole [Role for branch]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|UniqueEmail|en|IND [+91]|UniqueMobile|User creation successful|

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


Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Branch User Creation in Second Institution
Meta:
@Regression
Given that user is on channelManagement Page
When user clicks on Branch User Create link
Then user checks if EmailId and MobileNumber are mandatory
And user provide Branch User's ParentID,RoleID,UserID and UserName
And user enters Branch User's Address,Country,PostalCode,PreferredLanguage and ISDCode
And user enters Branch User's unique EmailId and unique MobileNumber
And user clicks on create button
And user should get the successful Message


Examples:
|ParentID|RoleID|UserID|UserName|Address|Country|PostalCode|EmailId|PreferredLanguage|ISDCode|MobileNumber|Message|
|SBBranchName [SBBranch]|SBBranchRole [SBBranchRole]|UniqueUserID|AutoUserName|AutoAddress|SPAIN [724]|411006|PreviousEmail|en|IND [+91]|PreviousMobile|User creation successful|


Scenario: Logout from MPTS Agent Portal Application for Second Institution
Meta:
@Regression
Then user logouts from agent portal


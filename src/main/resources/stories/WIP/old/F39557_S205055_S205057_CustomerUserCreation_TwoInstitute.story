Narrative:
As a Customer User
I want to go to Customer Portal and check validation of Mobile Number and 
Email ID while creating Customer users for two different Institutions

Meta:
@all
@UI
@R6-Iteration-2
@F39557
@S205055
@S205057
@CustomerTwoInstitution
@Centaurus
	
Scenario: Login to MPTS Customer Portal Application for First Institution
Meta:
@Regression
Given user login to customer portal with userName and password
When user selects desired institution
Then user should be in the home page and validate the institution

Examples:
|userName|password|institution|
|AdminUser1|AdminPassword1|Institution1|

Scenario: Verificaiton of both EmailID and MobileNumber's uniqueness for Customer User Creation
Meta:
@Regression
Given user is logged to Customer Portal
When user navigates to Administration page
And user provides UserID, UserName, Role, LanguagePreference, TimeZone
And user provides unique EmailId, CountryCode and unique MobileNumber
And user also provides UserAccountExpiryDate, ConcurrentLoginAllowed, MaximumConcurrentUser
And user checks the desired institution for newly created user
Then user should get created with successful Message

Examples:
|EmailId|CountryCode|MobileNumber|UserID|UserName|Role|LanguagePreference|TimeZone|UserAccountExpiryDate|ConcurrentLoginAllowed|MaximumConcurrentUser|Message|
|UniqueEmail|IND [+91]|UniqueMobile|UniqueUserID|AutoUserName|API ROLE [ROLE000042]|English [EN]|GMT|MMMM/dd/yyyy|Yes [Y]|10|Record Added Successfully.|

Scenario: Logout from MPTS Customer Portal Application for First Institution
Meta:
@Regression
Then user logouts from customer portal

Scenario: Login to MPTS Customer Portal Application for Second Institution
Meta:
@Regression
Given user login to customer portal with userName and password
When user selects desired institution
Then user should be in the home page and validate the institution

Examples:
|userName|password|institution|
|AdminUser2|AdminPassword2|Institution2|


Scenario: Again Verificaiton of both EmailID and MobileNumber's uniqueness for Customer User Creation
Meta:
@Regression
Given user is logged to Customer Portal
When user navigates to Administration page
And user provides UserID, UserName, Role, LanguagePreference, TimeZone
And user provides unique EmailId, CountryCode and unique MobileNumber
And user also provides UserAccountExpiryDate, ConcurrentLoginAllowed, MaximumConcurrentUser
And user checks the desired institution for newly created user
Then user should be able to see error Message

Examples:
|EmailId|CountryCode|MobileNumber|UserID|UserName|Role|LanguagePreference|TimeZone|UserAccountExpiryDate|ConcurrentLoginAllowed|MaximumConcurrentUser|Message|
|PreviousEmail|IND [+91]|PreviousMobile|UniqueUserID|AutoUserName|API ROLE [ROLE000042]|English [EN]|GMT|MMMM/dd/yyyy|Yes [Y]|10|Mobile number should be unique. Entered mobile number is already registered against some other User.|

Scenario: Logout from MPTS Customer Portal Application for Second Institution
Meta:
@Regression
Then user logouts from customer portal
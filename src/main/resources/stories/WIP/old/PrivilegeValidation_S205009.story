Narrative:
As a(n) customer portal user
I want to new configuration setup to define settlement bins provided by NPCI for an institution
So that device bin, settlement bin, product code and participant id shared by NPCI can be configured on the platform for validations and necessary outgoing file generation.


Meta:
@RupaySettlement
@R6releaseAutomation

Scenario: TC264384--Privilege validation for RuPay Settlement Bin Configuration  
Meta:
@TC264384
@TCName TC264384_Privilege validation for RuPay Settlement Bin Configuration
@sheetName S205009
Given that a new menu option should be available at Institution level-Rupay Settlement Bin
When the privileges are assigned to the user for this screen
Then the user should be able to access the new screen
 			 
Scenario: TC264476--RuPay Settlement Bin Configuration 
Meta:
@TC264476 
@TCName TC264476_RuPay Settlement Bin Configuration
@sheetName S205009
Given new menu option is available at institution level-rupay rettlement bin
When user tries to configure the settlement bin
Then user should be able to assign multiple settlement bin for a participant id

					 
Scenario:TC264385--Privilege validation for RuPay Settlement Bin Configuration  
Meta:
@TC264385 
@TCName TC264385_Privilege validation for RuPay Settlement Bin Configuration
@sheetName S205009
Given that a new menu option should be available at Institution level-Rupay Settlement Bin
When the privileges are not assigned to the user for this screen
Then the user should not be able to access the new screen


Scenario: TC264477--Multiple product code validation for RuPay Settlement Bin Configuration 
Meta:
@TC264477 
@TCName TC264477_Multiple product code validation for RuPay Settlement Bin Configuration
@sheetName S205009
Given that a new menu option is available at Institution level-Rupay Settlement Bin
When the user tries to configure the settlement bin
Then user can assign one device bin to multiple product code
And the product pair of device vin can only be linked to one settlement bin it cannot be mapped to any other settlement bill
And delete will be allowed without any constraint

Scenario:TC264387--RuPay Settlement Bin Configuration   
Meta:
@TC264387  
@TCName TC264387_RuPay Settlement Bin Configuration
@sheetName S205009
Given that a new menu option should be available at Institution level-Rupay Settlement Bin
When the privileges are assigned to the user for this screen
Then the user should be able to configure device bin Field and Length of the field is 6 digit
And Settlement bin is mandatory field for all Products and Length of the field will be 6 digit alphanumeric with no special characters allowed
And Product code-Mandatory Field-Drop Down
And The values of product code should be configurable at system level
And Participant Id-Mandatory Field-Length of the field is 11. It will be used for generating outgoing files to be staged to NPCI
 

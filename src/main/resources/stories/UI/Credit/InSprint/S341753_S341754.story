!-- author: e075551
Narrative:
In order to validate Customer Care International and VIP Number while Instiution Creation 
As a user
I want to add Customer Care International and VIP Number


Meta:
@TCName TCInstituteCreationCR
@testDataFileName testdata
@sheetName Institute	
@CustomerCareIntlVIP
				 
Scenario:1  Add Customer Care International and VIP Number
Given login to bank as a Bankadmin
When user adds the Customer Care Interantional and VIP Number while creating new Credit Institute
Then user should be able to create new institute
Then user should be able to add Customer Care Interantional and VIP Number


Scenario:2  Edit the Customer Care International and VIP Number
Meta:
@CustomerCareIntlVIP2

Given login to bank as a Bankadmin
When user updates the Customer Care Interantional and VIP Number while editing Institute
Then Institute should be get updated


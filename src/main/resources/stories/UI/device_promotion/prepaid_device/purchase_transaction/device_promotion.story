!-- @author: E074127

Narrative:
As a Customer portal user
I want to add a device promotion plan into the system 
so that it can be tested with the existing transaction plans

Meta:
@DevicePromotionPlan
@StoryName DevicePromotionPlan

Scenario: To verify that the user is able to add a new Device Promotion Plan for the system
Meta:
@AddDevicePromotionPlan
Given user is logged in institution
When user creates device promotion plan code for credit product
Then update Credit device with promotion plan
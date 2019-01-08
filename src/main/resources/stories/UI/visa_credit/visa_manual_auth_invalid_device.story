!-- @author: E076560
Narrative:
As a Customer portal user
I want to validate manual auth is not allowed on invalid device
So that invalid device is not authorized

Meta:
@StoryName credit_emv_corp_limit
@visa_manual_auth_invalid_device

Scenario:1 Manual auth on invalid device no
Given setting json values in excel for Credit
When user is logged in institution
And user raises an authorization request for invalid device
Then authorization should not be allowed
And user sign out from customer portal
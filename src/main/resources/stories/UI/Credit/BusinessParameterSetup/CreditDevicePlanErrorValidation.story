Narrative:
As a(n)  Customer portal user 
I want to configure the new institute with the required setup
So that new device can be created for Prepaid


Meta:
@CreditRegression
@BusinessParameterSetup

Scenario: Scenario1 - Institution parameter setup for prepaid type/ Mastercard
Meta:
@CreditDevicePlan
@TCName TC542565_CreditDecivePlan
@sheetName CreditDevicePlan
Given login to portal as existing bank as a Customeruser
When user wants to mandatory field validations on add device plan page
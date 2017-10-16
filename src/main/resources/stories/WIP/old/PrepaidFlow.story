Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta: 
@Issuing_Prepaid_Application


					 
Scenario:  A scenario is collection of executable steps of different
Given relogin to existing bank

When user creates StatementMessagePlanForPrepaid
When user creates MarketingMessagePlanForPrepaid
When user creates PrepaidStatementPlan
When user creates TransactionPlanForPrepaid
When user creates TransactionLimitPlanForPrepaid
When user creates DocumentChecklistForPrepaid
When user creates BusinessMandatoryFieldsForPrepaid
When user creates DeviceCardPackTemplate
When user creates EmbossingTemplate
When user creates Vendor
When user creates DeviceJoiningFeeForPrepaid
When user creates DeviceEventBasedFeePlanForPrepaid
When user creates DevicePlanForPrepaid
When user creates WalletFeePlan
When user creates WalletPlanForPrepaid
When user creates ProgramForPrepaid
When user creates DeviceRangeForPrepaid
When user creates EmbossingPriorityPass
When user creates BulkDeviceRequest

When user creates BulkDeviceGeneration
When user creates PreProductionBatch
When user creates DeviceProductionBatch
Then an Embossed file will get generated in the server path

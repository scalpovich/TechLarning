!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to Generate CSV file for Account Dump

Meta:
@StoryName client_customer_id_credit_emv_retail
Scenario:  To verify that the Account Dump file should be generated in .CSV format
Given setting json values in excel for Credit
And user is logged in institution
When Account Dump [ACCOUNT_DUMP] download batch is executed for Credit [C] user
Then ACC file is successfully downloaded ACCOUNT_DUMP
And user logouts from customer portal

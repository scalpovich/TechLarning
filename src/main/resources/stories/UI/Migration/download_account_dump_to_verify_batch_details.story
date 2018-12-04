!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to verify the batch details of Account Dump

Meta:
@StoryName client_customer_id_credit_emv_retail
Scenario: Verify that existing screen of batch details should be displayed with the relevant information after submitting the batch for processing
Given setting json values in excel for Credit
And user is logged in institution
When Account Dump [ACCOUNT_DUMP] download batch is executed for Credit [C] user
Then user logouts from customer portal
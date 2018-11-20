!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to display Client Customer ID in Card Holder Dump

Meta:
@StoryName client_customer_id_credit_emv_retail
Scenario:  To verify Client Customer ID is displayed in Card Holder Dump for Product type Credit
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills CLIENT_CUSTOMER_ID as Business Mandatory Field for credit product
And User fills Device Range section for credit product
And "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And Cardholder Dump [CARDHOLDER_DUMP] download batch is executed for Credit [C] user
Then CHD file is successfully downloaded CARDHOLDER_DUMP
And user compares mandatory field with a position 178 in downloaded file
And user logouts from customer portal

!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to display Client Customer ID in Card Holder Dump

Meta:
@StoryName client_customer_id_credit_emv_retail
Scenario:  To verify Client Customer ID is displayed in Card Holder Dump for Product type Credit
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And User fills CLIENT_CUSTOMER_ID as Business Mandatory Field for credit product
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And User search for new device on helpdesk screen for credit and validates the mandatory field
And Cardholder Dump [CARDHOLDER_DUMP] download batch is executed for Credit [C] user
Then CHD file is successfully downloaded CARDHOLDER_DUMP
And user compares mandatory field with a position 274 in downloaded file
And user logouts from customer portal

Narrative:
As a(n)  Customer portal user 
I want to verify points are accrued within the maximum points defined in event based loyalty points in the loyalty plan for the period - Monthly - Active
So that the Loyalty points can be calculated

Meta:
@StoryName prepaid_eventBased_loyalty		 

Scenario: 1.1-Loyalty program setup - Credit
Given setting json values in excel for Credit
When user is logged in institution
And user selects all the transactions for loyalty transaction plan
And for Magnetic Stripe Card [1] User fills Device Plan for Credit product for Mastercard
And User fills Wallet Fee Plan for Credit product
And User fills Wallet Plan for Credit product and program Retail Credit Card [9]
And User Primary Device fills New Program Retail Credit Card [9] section for Credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for Credit [C] product
And Credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Credit processes pre-production batch using new Device
And Credit processes deviceproduction batch using new Device for Supplementary
And user adds event based loyalty plan for product CREDIT and type CREDIT
And user adds posts the event based loyalty points for product CREDIT
Then user has loyalty points details for CREDIT device
And user verifies loyalty points for event based loyalty plan after posting
And user sign out from customer portal

Scenario: 1.2-Loyalty program setup - Credit- points debited
Given setting json values in excel for Credit
When user is logged in institution
And user adds event based loyalty plan for product CREDIT and type DEBIT
And user adds posts the event based loyalty points for product CREDIT
Then user has loyalty points details for CREDIT device
And user verifies debited loyalty points for event based loyalty plan after posting
And user sign out from customer portal
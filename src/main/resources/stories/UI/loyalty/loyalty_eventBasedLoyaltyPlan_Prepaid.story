Narrative:
As a(n)  Customer portal user 
I want to verify points are accrued within the maximum points defined in event based loyalty points in the loyalty plan for the period - Monthly - Active
So that the Loyalty points can be calculated

Meta:
@StoryName prepaid_eventBased_loyalty		 

Scenario: Loyalty program setup - prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And user selects all the transactions for loyalty transaction plan
And for Magnetic Stripe Card [1] User fills Device Plan for Prepaid product for Mastercard
And User fills Wallet Fee Plan for Prepaid product
And User fills Wallet Plan for Prepaid product and program Retail General Purpose Card
And User Primary Device fills New Program Retail General Purpose Card section for Prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for Prepaid [P] product
And Prepaid device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And Prepaid processes pre-production batch using new Device
And Prepaid processes deviceproduction batch using new Device for Supplementary
And user adds event based loyalty plan for product PREPAID and type CREDIT
And user adds posts the event based loyalty points for product PREPAID
Then user has loyalty points details for PREPAID device
Then user verifies loyalty points for event based loyalty plan after posting


Scenario: Loyalty program setup - Prepaid- points debited
Given setting json values in excel for Prepaid
When user is logged in institution
And user adds event based loyalty plan for product PREPAID and type DEBIT
And user adds posts the event based loyalty points for product PREPAID
Then user has loyalty points details for PREPAID device
And user verifies debited loyalty points for event based loyalty plan after posting
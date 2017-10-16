!-- @author: E074127
Narrative:
As a Customer portal admin user
I want to add a SDN Verification into the system 
so that it can be used further in the system

Meta:
@AddSDNVerification

Scenario: To verify that the user is able to add a SDN Verification Plan into the system

Meta:
@TCName TC_AddCurrencyExchangeRates
@sheetName CurrencyExchangeRates
@all
@R7Regression
@Sanity
Given login to bank as a Bankadmin
When user navigates to SDN verification setup page
And user adds the SDN verification plan into the system
Then verify that the SDN verification plan is added into the system
Narrative:
In order to validate billing with statemnt create device with billing cycle 1 perform authorization with clearing along with billing batches  
As a user
I want to assert unbilled and billed amount on helpdesk and validate statement generated

Meta:
@CreditRegression
@StoryName credit_emv_retail_loan
@Individual
@Primary	 
Scenario:1.0 creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
When user verifies loan account details
And user sign out from customer portal
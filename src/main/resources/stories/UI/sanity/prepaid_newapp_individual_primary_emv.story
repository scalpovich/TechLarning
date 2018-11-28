Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to assert card creation

Meta:
@StoryName credit_card
@SanityPack
		 
Scenario:creation of mastercard_individual_primary_emv prepaid device
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Corporate General Purpose Card [8]
And User fills MCC Rules for prepaid product
And User Primary fills new Program Corporate General Purpose Card [8] section for prepaid product for mastercard
And User fills Device Range section for prepaid product
And prepaid device is created using new Application screen for Corporate [1] and "Primary Device" and New Client and EMV Card
And user searches for created application
And prepaid processes pre-production batch using new Application
And prepaid processes deviceproduction batch using new Application
And new Application processes pin generation batch for prepaid
Then User search for new application on search screen for prepaid and validates the status as NORMAL
And user sign out from customer portal
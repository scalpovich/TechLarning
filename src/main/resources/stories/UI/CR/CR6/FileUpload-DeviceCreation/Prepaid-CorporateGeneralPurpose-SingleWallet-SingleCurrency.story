Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded and use device for transaction
@Meta:
Atul_Test3

Scenario: Verify system allows onboarding for new prepaid customer using application upload funcationality
Meta:
@CR6
@Scenario1_AddLoyaltyPlan
@TCName TC1LoyaltyPlanCreation
@sheetName LoyaltyPlan
@FileUpload

!-- Given customerAdmin provides privilege to Swapnil to process batches
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose
Then Program should get created
When user creates a Device Range for product Prepaid
When user creates Application Upload Prepaid batch file and uploads it on server for Individual
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When User search for device on search screen for product type prepaid and validates the status as NORMAL [0]
Then user logouts from customer portal
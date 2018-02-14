prepaid virtual retail general purpose card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid virtual retail general purpose card for client

Meta:
@StoryName p_virt_retail_general_purpose
@oldReferenceSheet_S203707
@SanityCards

Scenario: Set up prepaid virtual retail general purpose card
Meta: 
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without pin without dedupe
Then prepaid device is created
When user searches for created application
When prepaid processes pre-production batch using new Application
Then User search for new application on search screen for prepaid and validates the status as NORMAL
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
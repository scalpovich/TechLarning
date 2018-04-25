prepaid virtual retail general purpose card setup

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid virtual retail general purpose card for client

Meta:
@StoryName p_virt_retail_general_purpose
@oldReferenceSheet_S203707
@SanityCards
@UISanity

Scenario: Set up prepaid virtual retail general purpose card
Meta: 
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "static virtual" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
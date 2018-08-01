prepaid emv corporate giftcard card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv corporate giftcard card for client

Meta:
@StoryName p_emv_corp_gift

Scenario: Set up prepaid emv corporate giftcard card using applicationUpload
Meta:
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin for ApplicationUpload
When user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
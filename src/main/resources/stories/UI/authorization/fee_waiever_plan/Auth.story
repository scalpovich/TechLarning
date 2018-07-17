debit emv corporate card authorisation

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp

Scenario: Auth Search
Given user is logged in institution
Then search Purchase with Cash back authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal
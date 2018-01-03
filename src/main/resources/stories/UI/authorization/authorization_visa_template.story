Sample VISA Test

Narrative:
In order to perform Visa Interface transaction
As an issuer
I want to perform a sample transaction

Meta:
@StoryName sample_visa_authorization_Test
@SimulatorSession VISA

Scenario: VISA transactions

!-- Given connection to VISA is established
When perform an cwdl VISA transaction
Then VISA test results are verified for cwdl
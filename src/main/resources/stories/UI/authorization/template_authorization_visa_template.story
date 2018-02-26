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
When perform an LoadAndActivate_with_pin VISA transaction
Then VISA test results are verified for LoadAndActivate_with_pin
Then VISA simulator is closed
Narrative:
In order to a validate 3 d secure Transaction on credit device
As a user
I want to perform 3 d secure Transaction without CVV2
Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
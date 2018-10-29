Narrative:
As a(n)  Customer portal user 
I want to configure the LoyaltyProgram
In order to manually reverse transaction
So that reversed accrued loyalty points can be verified
Meta:
@StoryName credit_msr_retail_loyalty

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

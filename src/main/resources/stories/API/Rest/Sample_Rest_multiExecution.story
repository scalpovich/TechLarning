Narrative:
As a User
I want to Execute multiple API
In order to Validate json response

Meta:
@StoryName post_Data
@storyType API

Scenario: update sample json and validate response
Meta:
@storyType API
@datasheet errorMesseges_IsEligible
Given user updates isEligibleRequest.json file to sends post request at isEligible and validate data

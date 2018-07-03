Stop_List: Screen to add multiple reasons of stopping card in stop list section

Narrative:
In order to stop the card, 
As an User
I want to add multiple reason to stop the card in stop list screen

Meta:
@StoryName STOP_LIST_REASON_SCREEN

Scenario: User can add multiple reason to stop the card in stop list screen
Given user is logged in institution
Then user can add "Lost" in stoplist reason page
And user can add "Stolen" in stoplist reason page
And user can add "Counterfeit" in stoplist reason page
Then user can add "Returned" in stoplist reason page
And user can add "Expired" in stoplist reason page
And user can add "Damaged Card" in stoplist reason page
And user can add "Emergency Replacement" in stoplist reason page
And user can add "Erroneous Card" in stoplist reason page
Then user signs out from customer portal

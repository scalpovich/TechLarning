Stop_List_Reason: Screen to add multiple reasons of stopping card in stop list section

Narrative:
In order to stop the card, 
As an User
I want to add multiple reason to stop the card in stop list screen

Meta:
@StoryName STOP_LIST_REASON_SCREEN

Scenario: User can add multiple reason to stop the card in stop list screen
Given user is logged in institution
Then user add all raesons in stoplist reason page
And user signs out from customer portal

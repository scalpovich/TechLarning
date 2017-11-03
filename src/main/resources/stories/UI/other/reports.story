reports

Narrative:
In order to provide to view various reports
As an issuer
I want to download reports

Meta:
@StoryName reports

Scenario: Program Balance Summary, Auth and Clearing reports download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
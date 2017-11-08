disputes

Narrative:
In order to process dispute
As a user
I want to run dispute life cycle

Meta:
@StoryName disputes
@SanityDispute
@FullSanity

Scenario: A potential charge back report and validate retrieval request creation Process
Given user is logged in institution
When Not file is modified
And NOT file is uploaded after modification
And matching batch is executed
And a retrival request is created using ARN Number
And Charge back is created for a transaction
And Download the IPM file
Then verify the downloaded IPM file in MCPS
And verify for the status in dispute history
And verify report for Potential  Chargeback Reports is downloaded

Scenario: System is able to process incoming clearing files and process retrieval request or response
Meta:
@TestId
Given user is logged in institution
When user updates retrieval response
Then verify report for Potential  Chargeback Reports is downloaded
And verify for the status in dispute history
And user signs out from customer portal

Scenario: The System is able to process 1st Presentment reversal
Given user is logged in institution
When user has wallet number information for prepaid device which is exsiting
And user has current wallet balance amount information for prepaid device
And Not file is modified
And NOT file is uploaded after modification
And matching batch is executed
And update IPM file for trasaction reversal
And NOT file is uploaded after modification
And matching batch is executed
Then search with ARN in transaction screen and balance should be credited
And search with ARN in transaction screen and status should be Reversal [R]
And after transaction reversal wallet balance amount for prepaid device is updated correctly

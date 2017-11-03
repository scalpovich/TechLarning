Reconciliation - Verification of Report

Narrative:
In order to verify that all pages are rendered correctly
As a user
I want to traverse all pages and tabs

Meta:
@StoryName S2242889
@SanityRecon
@FullSanity

Scenario: Reconciliation
Meta:
@TestId TC408602
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
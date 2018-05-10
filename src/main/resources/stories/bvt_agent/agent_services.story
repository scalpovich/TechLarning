Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate services tab UI verification Agent Portal Pages Loaded based on role Agent

Meta:
@StoryName S224290
@AgentBV

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Device Sale Page
Meta:
@TestId TC378874
Given user is logged in agent portal as agent user
When user navigates to device sale page
Then device sale page is loaded and master detail content title is Sale
And DeviceSale page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Application Correction Page
Meta:
@TestId TC378869
Given user is logged in agent portal as agent user
When user navigates to application correction page
Then application correction page is loaded and master detail content title is Application Correction Details
And ApplicationCorrection page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Checker Page
Meta:
@TestId TC378871
Given user is logged in agent portal as agent user
When user navigates to checker page
Then checker page is loaded and master detail content title is Device Sale Checker
And Checker page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - De-dupe Re-Verification & Approval Page
Meta:
@TestId TC378873
Given user is logged in agent portal as agent user
When user navigates to dedupe reverification approval page
Then dedupe reverification approval page is loaded and master detail content title is De-dupe Re-verification & Approval
And DedupeReverificationApproval page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - KYC Update Page
Meta:
@TestId TC378876
Given user is logged in agent portal as agent user
When user navigates to kyc update page
Then kyc update page is loaded and master detail content title is KYC Updation
And KYCUpdate page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Instant Device Replacement Page
Meta:
@TestId TC378875
Given user is logged in agent portal as agent user
When user navigates to instant device replacement page
Then instant device replacement page is loaded and master detail content title is Instant Device Replacement
And InstantDeviceReplacement page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Currency Setup Page
Meta:
@TestId TC378872
Given user is logged in agent portal as agent user
When user navigates to currency setup page
Then currency setup page is loaded and master detail content title is Currency Setup
And CurrencySetup page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Change Currency Priority Page
Meta:
@TestId TC378870
Given user is logged in agent portal as agent user
When user navigates to change currency priority page
Then change currency priority page is loaded and master detail content title is Change Currency Priority
And ChangeCurrencyPriority page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Activate/ De-activate Sub account Page
Meta:
@TestId TC378868
Given user is logged in agent portal as agent user
When user navigates to activate deactivate sub account page
Then activate deactivate sub account page is loaded and master detail content title is Activate / De-activate Wallet
And ActivateDeactivateSubAccount page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Limited Validity Virtual Card Cancellation Page
Meta:
@TestId TC378877
Given user is logged in agent portal as agent user
When user navigates to limited validity virtual card cancellation page
Then limited validity virtual card cancellation page is loaded and master detail content title is Limited Validity Virtual Card Cancellation
And LimitedValidityVirtualCardCancellation page of services tab is rendered correctly
And user sign out from agent portal
!-- @author: E074127
Narrative:
As a Customer portal user
I want to reissue TPIN for a credit device  
so that the user can verify the reissue TPIN functionality

Meta:
@StoryName reissue_tpin_helpdesk
@helpdeskReissueTPIN_email

Scenario:1 creation of mastercard retail credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And user sign out from customer portal

Scenario:2 To Verify that the user reissues the tpin download request for credit through helpdesk
Given user is logged in institution
When credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user reissues TPIN request for emv
Then user sign out from customer portal

Scenario: 3 To verify that the EMAIL is set to the users mail ID in the TPIN_DOWNLOAD
Given user is logged in institution
When reissue TPIN dump download batch is processed for credit
Then verify that the EMAIL field is set to email in the TPIN reissue DAT file
And user sign out from customer portal
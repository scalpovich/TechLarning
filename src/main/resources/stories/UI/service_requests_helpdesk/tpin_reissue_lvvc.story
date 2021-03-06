!-- @author: E074127
Narrative:
As a Customer portal user
I want to reissue TPIN for a credit device  
so that the user can verify the reissue TPIN functionality

Meta:
@StoryName reissue_tpin_helpdesk
@helpdeskReissueTPIN_LVVC

Scenario:1 creation of mastercard_Retail Credit Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for Limited Validity Virtual Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and Limited Validity Virtual Card
And user sign out from customer portal

Scenario:2 To Verify that the user is not able to raise an TPIN SR for lvvc through helpdesk
Given user is logged in institution
When credit processes pre-production batch using new Device
And device has "normal" status
And user reissues TPIN request for lvvc
Then verify that the reissue TPIN request is not allowed for LVVC
And user sign out from customer portal
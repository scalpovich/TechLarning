!-- @author: E074127
Narrative:
As a Customer portal user
I want to stoplist and withdraw stoplist a credit device  
so that the user can verify the stoplist functionality

Meta:
@StoryName reissue_tpin_helpdesk
@helpdeskStoplistCredit

Scenario:1 creation of mastercard_Retail Credit Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for Static Virtual Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and Static Virtual Card
And user sign out from customer portal

Scenario:2 To Verify that the user can stoplist a credit device through helpdesk
Given user is logged in institution
When credit processes pre-production batch using new Device
And device has "normal" status
And user reissues TPIN request for svc
Then user sign out from customer portal

Scenario:3 To verify that the TPIN dump is downloaded successfully
Given user is logged in institution
When reissue TPIN dump download batch is processed for credit
Then verify that the device number is present in the TPIN reissue DAT file
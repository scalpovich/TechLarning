Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 


Meta:  

@Regression
@UI
@S205477
@TC269055
@TC269060 
@TCName TC269055_QMR report Corresponding device reported as a single card 
@sheetName QMRReporting 

Scenario:Corresponding device reported as a single card in Accounts and Cards

Given login to portal as existing bank as a user
When User executes the compliance reports batch
Then User download the QMR report
Then User validate the new cards genereted
And User valildate the summation of card disbursement
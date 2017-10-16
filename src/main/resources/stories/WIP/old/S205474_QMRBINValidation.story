Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 


Meta:  

@Regression
@UI
@S205474
@TC269008
@TCName TC2698
@sheetName QMRReporting
Scenario: Verify QMR report shows all the BINs :both exhausted and active BINs

Given login to portal as existing bank as a user
When User executes the compliance reports batch
Then User download the QMR report
Then User validate all BIN present in report
And User valildate BIN starting from next Page

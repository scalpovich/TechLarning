Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:  
@Regression
@UI
@S205471
@TC268416
@All
@TCName TC268416_QMR report heading validation
@sheetName QMRReporting
Scenario: QMR Debit report heading validation 

Given login to portal as existing bank as a user
When User executes the compliance reports batch
Then User download the QMR report
And User validate all given heading in report
And User validate all header and footer in report
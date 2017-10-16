Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 


Meta:  
@Regression
@UI
@S205478

Scenario: Transaction count and transaction amount AND ‘Balance transfer’ and ‘convenience check’ fields 
Meta:
@TCName TC269104_Transaction count and transaction amount AND Balance transfer and convenience check fields. 
@sheetName QMRReporting
@TC269104
@TC269108
@TC269115
@TC269118

Given login to portal as existing bank as a user
When User executes the compliance reports batch
Then User download the QMR report
Then User validates Transaction Amount heading
And User valildate Account terminated heading

@Regression
@UI
@TC269118
@TCName TC269118_Different currencies selected on screen and for pulling the report.  
@sheetName QMRReporting
Scenario: Different currencies selected on screen and for pulling the report. 

Given login to existing bank as a Customerportaluser
When User executes the compliance reports batch
And User download the QMR report
Then User validate the null report for diffrent currency

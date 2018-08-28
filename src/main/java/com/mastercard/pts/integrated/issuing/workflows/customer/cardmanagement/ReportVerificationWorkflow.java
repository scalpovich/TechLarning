package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReportVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.PDFUtils;

@Workflow
public class ReportVerificationWorkflow {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	@Autowired
	KeyValueProvider provider;
	
	ReportVerificationPage page;

	private static final Logger logger = LoggerFactory.getLogger(AdministrationHomePage.class);

	public static final int BILL_AMOUNT_INDEX_VALUE = 3;


    public void verifyGenericReport(GenericReport report) {
		page = (ReportVerificationPage)getInstance(report.getReportName());
		Map<Integer, String> reportContent = getGenericReport(report);
		reportContent.forEach((k,v)-> {
			if(v.contains(report.getDeviceNumber())){
			report.getFieldToValidate().forEach((field,fieldValue) ->{
				assertTrue(field+" did not match with Authoraization Report content", v.contains(fieldValue));
				logger.info("{field} is present in the report",fieldValue);
			});
			}
			else{
				assertTrue("Device Number is not present in the Report"+report.getDeviceNumber(),false);
			}
		});
	}
    
    public Map<Integer, String> getGenericReport(GenericReport report) {
    	deleteExistingReportsFromSystem(report.getReportName());
    	page = navigator.navigateToPage(page.getClass().getSimpleName());
		String reportUrl = page.generateReport(report);
		report.setReportUrl(reportUrl);
		return getReportContent(report);
	}
    
    public Map<Integer, String> getReportContent(GenericReport genericReports) {
		PDFUtils pdfutils = new PDFUtils();
		Map<Integer, String> records = pdfutils.getContentRow(genericReports);
		return records;
	}
    
    public void deleteExistingReportsFromSystem(String reportName)
	{
		for (File file: new File(PDFUtils.getuserDownloadPath()).listFiles()) {
			if (!file.isDirectory()&& file.getName().startsWith(reportName))   	
				file.delete();
		}
	}   
    
    // Please make sure pass the exact name in Steps as the name of class
    public Object getInstance(String className){
			try {
				return Class.forName("com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement."+className+"ReportPage").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 	
    }
}
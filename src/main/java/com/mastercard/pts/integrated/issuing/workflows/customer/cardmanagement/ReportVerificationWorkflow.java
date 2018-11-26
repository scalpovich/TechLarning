package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApplicationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceActivityPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReportVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
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
	
	Boolean verificationStatus;
	
    public void verifyGenericReport(GenericReport report) {
		page = (ReportVerificationPage)getInstance(report.getReportName());
		Map<Object, String> reportContent = getGenericReport(report);
		if(report.getReportRegEx()==null&&report.getReportRegEx().isEmpty()){
			reportContent.forEach((k,v)->{
				report.getFieldToValidate().forEach((field,fieldValue) ->{
					if(field.contains((String)k)){
						assertTrue(field+" did not match with Authoraization Report content", v.equalsIgnoreCase(fieldValue));
						}
					else{
						assertTrue("Field not present in the Report"+report.getDeviceNumber(),false);
					}
					logger.info("{field} is present in the report",fieldValue);
				});
				
			});
		}
		else{
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
	}
    
	public void verifyReportGenerationAppRejectReport(GenericReport reports) {
		reports.setReportName(Constants.APP_REJECT_REPORT);
		deleteExistingReportsFromSystem(reports.getReportName());
		ApplicationPage page = navigator.navigateToPage(ApplicationPage.class);
		String reportUrl = page.generateApplicationRejectReport(reports.getReportName());
		reports.setReportUrl(reportUrl);
		Map<Object, String> reportContent = getReportContent(reports);
		reportContent.forEach((k, v) -> {
			reports.getFieldToValidate().forEach((field, fieldValue) -> {
				if (v.contains(fieldValue)) {
					toggle();
					logger.info("{field} is present in the report", fieldValue);
				}
			});
		});
		assertTrue("Application Number is not present in the System", verificationStatus);
	}
	
	public void generateDeviceActivityReport(Device device,GenericReport report,Program program) {
    	DeviceActivityPage page = navigator.navigateToPage(DeviceActivityPage.class);
		deleteExistingReportsFromSystem(report.getReportName());
		String reportUrl = page.generateDeviceActivityReport(device,report,program);
		report.setReportUrl(reportUrl);
		Map<Object, String> reportContent= getReportContent(report);
		logger.info("Client Code:" +report.getClientCode());
		reportContent.forEach((k,v)-> {
			if(v.contains(report.getClientCode())){
				toggle();
			}
		});		
		assertTrue("Client Code is not present",verificationStatus);
	}
	
	private void toggle(){
		verificationStatus = true;
	}
    
    public void verifyStatement(GenericReport report) {		
		Map<Object, String> reportContent = getReportContent(report);
		report.getFieldToValidate().forEach((field,fieldValue)-> {
				logger.info(field + "=" + fieldValue);	
				assertTrue(field+" Actual "+ reportContent.get(field)+" value does not match with expected : "+ report.getFieldToValidate().get(field), reportContent.get(field).contains(report.getFieldToValidate().get(field)));			
		});
	}
    
    public Map<Object, String> getGenericReport(GenericReport report) {
    	deleteExistingReportsFromSystem(report.getReportName());
    	page = navigator.navigateToPage(page.getClass().getSimpleName());
		String reportUrl = page.generateReport(report);
		report.setReportUrl(reportUrl);
		return getReportContent(report);
	}
    
    public Map<Object, String> getReportContent(GenericReport genericReports) {
		PDFUtils pdfutils = new PDFUtils();
		Map<Object, String> records = pdfutils.getContentRow(genericReports);
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
	public void verificationOfPDFFileForLVCCard(String reportURL, String password) {
		PDFUtils pdfutils = new PDFUtils();
		GenericReport report = new GenericReport();
		Device device = context.get(ContextConstants.DEVICE);
		report.setDeviceNumber(device.getDeviceNumber());
		report.setReportUrl(reportURL);
		MiscUtils.reportToConsole("PDF Report URL is : " + report.getReportUrl());
		report.setPassword("JOHN" + password);
		MiscUtils.reportToConsole("PDF Password is : " + report.getPassword());
		report.setReportName("LVC");
		report.setReportRegEx();
		Map<Object, String> records = pdfutils.getContentRow(report);
		records.forEach((k, v) -> {
			if (v.contains("Card Number")) {
				assertTrue("Card Number is incorrect in PDF File", v.contains(report.getDeviceNumber()));
			}
			if (v.contains("CVC2")) {
				String cvv2 = records.get(15);
				String[] cvvValue = cvv2.trim().split(":");
				logger.info(cvvValue[1]);
				device.setCvv2Data(cvvValue[1]);
			}
			if (v.contains("Expiry")) {
				String expiryDate = records.get(17);
				String[] expiryValues = expiryDate.trim().split(":");
				logger.info(expiryValues[1]);
				device.setExpirationDate(expiryValues[1]);
			}
			context.put(ContextConstants.DEVICE, device);
		});
	}
}
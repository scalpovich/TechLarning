package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyPointsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
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
	
	private static final int PDF_KEY_EXPIRY=17;
			
	private static final int PDF_KEY_CVC2=15;

	public static final String APPLICATION_REJECTED_IN_DEDUPE = "Application Rejected in Dedupe.";
		Boolean verificationStatus;
	
    public void verifyGenericReport(GenericReport report) {
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
					logger.info("{} is present in the report",fieldValue);
				});
				
			});
		}
		else{
		reportContent.forEach((k,v)-> {
			if(v.contains(report.getDeviceNumber())){
			report.getFieldToValidate().forEach((field,fieldValue) ->{
				assertTrue(field+" did not match with Report content", v.contains(fieldValue));
				logger.info("{} is present in the report",fieldValue);
			});
			toggle();
			}
		});
		assertTrue("Device Number is not present in the Report"+report.getDeviceNumber(),verificationStatus);
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
					logger.info("{} is present in the report", fieldValue);
				}
			});
		});
		assertTrue("Application Number is not present in the System", verificationStatus);
	}
	
	public void verifyDuplicateAppInAppRejectReport(GenericReport reports) {
		reports.setReportName(Constants.APP_REJECT_REPORT);
		deleteExistingReportsFromSystem(reports.getReportName());
		ApplicationPage page = navigator.navigateToPage(ApplicationPage.class);
		String reportUrl = page.generateApplicationRejectReportForUpload(reports.getReportName());
		reports.setReportUrl(reportUrl);
		Map<Object, String> reportContent = getReportContent(reports);
		reportContent.forEach((k, v) -> {
			reports.getFieldToValidate().forEach((field, fieldValue) -> {
				if (v.contains(fieldValue)) {
					if (v.contains(APPLICATION_REJECTED_IN_DEDUPE)) {
						toggle();
						logger.info("Application is Rejected in DeDupe/SDN");
					}
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
    	page = navigator.navigateToPage(report.getReportName()+"Report");
		String reportUrl = page.generateReport(report);
		report.setReportUrl(reportUrl);
		report.setPassword(((String)context.get(UserManagementSteps.USERNAME)).substring(0,4)+(new DateUtils()).getDateDDMMFormat());
		return getReportContent(report);
	}
    
    public Map<Object, String> getReportContent(GenericReport genericReports) {
		PDFUtils pdfutils = new PDFUtils();
		return pdfutils.getContentRow(genericReports);
	}
    
    public void deleteExistingReportsFromSystem(String reportName)
	{
		for (File file: new File(PDFUtils.getuserDownloadPath()).listFiles()) {
			if (!file.isDirectory()&& file.getName().startsWith(reportName))   	
				file.delete();
			else if(file.isDirectory() && file.getName().startsWith(reportName)) {
				try {
					FileUtils.deleteDirectory(file);
				} catch (IOException e) {
					e.printStackTrace();
		}
	}   
		}
	}   
    
    public String downloadAndVerifyLoyaltyReport(GenericReport report) {
    	deleteExistingReportsFromSystem(report.getReportName());
		LoyaltyPointsPage page = navigator.navigateToPage(LoyaltyPointsPage.class);
		page.selectReport("Loyalty Points Report");
		page.selectProductType(report.getDeviceType());
		page.selectLoyaltyPlan(report.getLoyaltyPlan());
		page.enterDeviceNumber(report.getDeviceNumber());
		page.selectFileType(report.getReportType());
		page.clickSubmitButton();
		String path = page.verifyReportDownloaded(report.getReportName(), "pdf");
		report.setReportUrl(path);
		//for excel report
		/*unziputils.unZipTheFile(path, report.getPassword(), PDFUtils.getuserDownloadPath());
			try {
			points = ExcelUtils.readExcelDataAgainst("");
		} catch (FilloException e) {
				e.printStackTrace();
		}*/
		//for pdf report
		Map<Object, String> reportContent = getReportContent(report);
		String[] points = reportContent.get(Constants.AVAILABLE_LOYALTY_POINTS).split("\\s");
		return points[0];
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
				String cvv2 = records.get(PDF_KEY_CVC2);
				String[] cvvValue = cvv2.trim().split(":");
				logger.info(cvvValue[1]);
				device.setCvv2Data(cvvValue[1]);
			}
			if (v.contains("Expiry")) {
				String expiryDate = records.get(PDF_KEY_EXPIRY);
				String[] expiryValues = expiryDate.trim().split(":");
				logger.info(expiryValues[1]);
				device.setExpirationDate(expiryValues[1]);
			}
			context.put(ContextConstants.DEVICE, device);
		});
	}
}
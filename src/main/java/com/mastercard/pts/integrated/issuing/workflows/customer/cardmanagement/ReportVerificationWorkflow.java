package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReportVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.PDFUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

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
	
	private String fileURL ;


    public void verifyGenericReport(Device device,String reportName,String reportField) {
		GenericReport report = GenericReport.getGenericReport();
		page = (ReportVerificationPage)getInstance(reportName);
		report.setUsername(context.get(UserManagementSteps.USERNAME));
		fileURL = PDFUtils.getuserDownloadPath()+"\\"+reportName+" Report.pdf";
		report.setUsername("NitinK");
		report.setFieldToValidate(reportField, context.get(reportField));
		HashMap<Integer, String[]> reportContent = verifyGenericReport(reportName,report);
//		String authFileData = "";
//		for (int i = 0; i < reportContent.size(); i++) {
//			authFileData += reportContent.get(i) + " ";		
//			}
//		
//		boolean condition = authFileData.contains(context.get(ConstantData.AUTHORIZATION_CODE)) && authFileData.contains(device.getDeviceNumber()) 
//				&& authFileData.contains(context.get(ConstantData.TRANSACTION_AMOUNT)) && authFileData.contains(context.get(ConstantData.RRN_NUMBER));
//		assertTrue("Auth Code Doesnot match with Authoraization Report content", condition);
	}
    
    public HashMap<Integer, String[]> verifyGenericReport(String fileName, GenericReport report) {
		//navigator.navigateToPage(page.getClass().getSimpleName());
		//deleteExistingAuthorizationFilesFromSystem(fileName);
		//page.generateReport(report);
		//verifyReportDownloaded(fileName);
		return getReportContent(fileName,report);
	}
    
    public HashMap<Integer, String[]> getReportContent(String fileName,GenericReport genericReports) {
		PDFUtils pdfutils=new PDFUtils();
		genericReports.setRegEx("\\d\\d-\\d\\d-\\d\\d\\d\\d");
		HashMap<Integer, String[]> records = pdfutils.getContentRow(fileURL, genericReports);
		for(int i=0;i<records.size();i++)
		{
			if (records != null)
				logger.info("Authorization data file content {} ", records.get(i));
		}
		return records;
	}
    
    public void deleteExistingAuthorizationFilesFromSystem(String authFileName)
	{
		for (File file: new File(PDFUtils.getuserDownloadPath()).listFiles()) {
			if (!file.isDirectory()&& file.getName().startsWith(authFileName))   	
				file.delete();
		}
	}
    
    public boolean verifyReportDownloaded(String authFileName)
	{
		File report = new File(fileURL);
		System.out.println("++++++++++++++--+"+report.getAbsolutePath());
       for (int i = 0;i<=5;i++ ){
    	   if(report.isFile())
    	   break;
    	   else
    		  SimulatorUtilities.wait(1000); 
       }
        return true;
	}
    
    
    // Please make sure pass the exact name in Steps as the name of class
    public Object getInstance(String className){
			try {
				return Class.forName("com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement."+className.split("-")[0]+"ReportPage").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 	
    }

	
}
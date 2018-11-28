package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReportVerificationWorkflow;

import junit.framework.Assert;

@Component
public class ReportVerificationSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private ReportVerificationWorkflow reportVerificationWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	private static final String MCC = "5999";
	
	private static final String COUNTRY = "INDIA";
	
	private static final String MERCHANT = "ABC123TESTMTF19";
	
	@Autowired
	private DBUtility dbUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportVerificationSteps.class);

	@Given("validate the $reportField in $reportName report")
	@Then("validate the $reportField in $reportName report")
	public void validateGenericReport(String reportFields, String reportName) {
		Device device = context.get(ContextConstants.DEVICE);
		GenericReport report = GenericReport.createWithProvider(provider);
		try{
		report.setReportName(reportName.split("-")[0]);
		report.setReportType(reportName.split("-")[1]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			logger.info("No Report Type is present here!!");
		}
		report.setDeviceNumber(device.getDeviceNumber());
			report.setFieldToValidate("MCC",MCC);
			report.setFieldToValidate("Country",COUNTRY);
			report.setFieldToValidate("Merchant",MERCHANT);
		report.setUsername(context.get(UserManagementSteps.USERNAME));
		reportVerificationWorkflow.verifyGenericReport(report);		
	}
	
	@When("verify application in application reject report")
	@Then("verify application in application reject report")
	public void verifyApplicationInApplicationRejectReport() {
		GenericReport report = GenericReport.createWithProvider(provider);
		report.setPassword(((String)context.get(UserManagementSteps.USERNAME)).substring(0,4)+(new DateUtils()).getDateDDMMFormat());
		Device device = context.get(ContextConstants.DEVICE);
		report.setFieldToValidate("application number", device.getApplicationNumber());
		reportVerificationWorkflow.verifyReportGenerationAppRejectReport(report);
	}

	@Then("verify loyalty points in loyalty report against $promoPlan for $type device")
	public void verifyLoyaltyReport(String promoPlan, String type) {
		Device device = context.get(ContextConstants.DEVICE);
		GenericReport report = GenericReport.createWithProvider(provider);
		String date = dbUtils.getCurrentDateForInstitution(context.get(Constants.USER_INSTITUTION_SELECTED));
		report.setPassword(((String)context.get(UserManagementSteps.USERNAME)).substring(0,4)+(new DateUtils()).getDateDDMMFormat(dbUtils.getCurrentDateForInstitution(context.get(Constants.USER_INSTITUTION_SELECTED))));
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		report.setDeviceType(type);
		report.setLoyaltyPlan(data.getLoyaltyPlan().substring(0, data.getLoyaltyPlan().indexOf('[')-1));
		report.setDeviceNumber(device.getDeviceNumber());
		report.setReportType("PDF Format [pdf]"); //("Excel Format [xlsDump]");
		report.setReportName(ConstantData.LOYALTY_POINTS_REPORT_FILENAME);
		report.setLoyaltyPromotionPlan(promoPlan);
		String loyaltyPoints = reportVerificationWorkflow.downloadAndVerifyLoyaltyReport(report);
		Assert.assertEquals(context.get(Constants.AVAILABLE_LOYALTY_POINTS), Double.parseDouble(loyaltyPoints));
	}
}
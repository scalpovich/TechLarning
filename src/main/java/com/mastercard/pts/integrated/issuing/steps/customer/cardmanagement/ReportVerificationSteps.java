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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReportVerificationWorkflow;

@Component
public class ReportVerificationSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private ReportVerificationWorkflow reportVerificationWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
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
		report.setUsername(context.get(UserManagementSteps.USERNAME));
		for(String field : reportFields.split(",")){
				report.setFieldToValidate(field, context.get(ConstantData.fromShortName(field)));
				logger.info("value of {field} is {value}",field,context.get(ConstantData.fromShortName(field)));
		}
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

}
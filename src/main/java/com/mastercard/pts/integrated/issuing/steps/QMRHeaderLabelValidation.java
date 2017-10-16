package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchProcessingPage;
import com.mastercard.pts.integrated.issuing.workflows.QMRReportFlows;

@Component
public class QMRHeaderLabelValidation extends AbstractBasePage {

	@Autowired
	QMRReportFlows reportFlows;
	BatchProcessingPage batchProcesingPage = new BatchProcessingPage();

	@Given("QMR_Report was read successfully")
	public void verify_That_QMR_Report_Was_Read_Successfully_1() {

		reportFlows.verifyQMRReportReadSuccessfully();

	}

	@When("User fetches all contents and extracts header labels")
	public void verify_That_User_fetches_All_Contents_And_Extracts_Header_Labels() {

		reportFlows.verifyThatUserFetchesAllContentsAndExtractsHeaders();

	}

	@Then("Then all headers were found as present")
	public void verify_That_All_Headers_Were_Found_As_Present() {

		reportFlows.verifyValidationIsSuccessful();
		reportFlows.clearStatusFlag();
	}

}

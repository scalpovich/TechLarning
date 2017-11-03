package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.AppEnvironment;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.LoginWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReconciliationWorkFlow;

@Component
public class ReportGenerationSteps {
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private DataProvider dataProvider;

	@Autowired
	private AppEnvironment environment;

	@Autowired
	private LoginWorkflow loginWorkflow;

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;

	@Given("User is logged in")
	public void givenUserIsLoggedInInstitution() {
		String userDefaultInstitution;
		Portal loginPortal = environment.getPortalByType(Portal.TYPE_CUSTOMER);
		userDefaultInstitution = Institution.createWithProvider(dataProvider).buildAbbreviationAndCode();
		loginWorkflow.logInInstitution(loginPortal, userDefaultInstitution);
	}

	@Then("Verify Program Balance Summary is downloaded")
	public void verifyReportForTransactionsWithProgramBalanceSummaryIsDownloaded() {
		Assert.assertTrue(reconciliationWorkFlow.verifyReportGenerationRecon());
	}

	@When("Clearing and EOD batches are run")
	public void whenPreclearingAndPreEODBatchesAreRun() {

		List<ProcessBatches> processBatches = new ArrayList<>();
		ProcessBatches prepaidEodProcessBatch = new ProcessBatches();
		prepaidEodProcessBatch.setProductType(provider.getString("BATCH_TYPE"));
		prepaidEodProcessBatch.setBatchName(provider.getString("BATCH_NAME_PREPAID_EOD"));
		prepaidEodProcessBatch.setProductType("");

		ProcessBatches preClearingBatch = new ProcessBatches();
		preClearingBatch.setProductType(provider.getString("BATCH_TYPE"));
		preClearingBatch.setBatchName(provider.getString("BATCH_NAME_PRE_CLEARING"));
		preClearingBatch.setProductType(provider.getString("PREPAID_PRODUCT_TYPE"));

		processBatches.add(preClearingBatch);
		processBatches.add(prepaidEodProcessBatch);

		reconciliationWorkFlow.runPreClearingAndPrepaidEodBatch(processBatches);
	}
	
	@Then("verify report for Auth is downloaded")
	public void verifyReportForAuthIsDownloaded() {
		Assert.assertTrue(reconciliationWorkFlow.verifyReportGeneration());
	}
	
	@Then("verify report for Clearing is downloaded")
	public void verifyReportForClearingIsDownloaded() {
		Assert.assertTrue(reconciliationWorkFlow.verifyReportGenerationClearing());
	}
}
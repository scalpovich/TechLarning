package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReconciliationWorkFlow;

@Component
public class ReconciliationSteps {
	private static final String BATCH_TYPE = "BATCH_TYPE";
	private static final String BATCH_NAME_POST_MAINTENENCE = "BATCH_NAME_POST_MAINTENENCE";
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;

	@Then("verify report for transactions with Program Balance Summary is downloaded")
	public void verifyReportForTransactionsWithProgramBalanceSummaryIsDownloaded() {
		Assert.assertTrue(reconciliationWorkFlow.verifyReportGenerationRecon());
	}

	@When("pre-clearing and Pre-EOD batches are run")
	public void whenPreclearingAndPreEODBatchesAreRun() {

		List<ProcessBatches> processBatches = new ArrayList<>();
		ProcessBatches prepaidEodProcessBatch = new ProcessBatches();
		prepaidEodProcessBatch.setProductType(provider.getString(BATCH_TYPE));
		prepaidEodProcessBatch.setBatchName(provider.getString("BATCH_NAME_PREPAID_EOD"));
		prepaidEodProcessBatch.setProductType("");

		ProcessBatches preClearingBatch = new ProcessBatches();
		preClearingBatch.setProductType(provider.getString(BATCH_TYPE));
		preClearingBatch.setBatchName(provider.getString("BATCH_NAME_PRE_CLEARING"));
		preClearingBatch.setProductType(provider.getString("PREPAID_PRODUCT_TYPE"));

		processBatches.add(preClearingBatch);
		processBatches.add(prepaidEodProcessBatch);

		reconciliationWorkFlow.runPreClearingAndPrepaidEodBatch(processBatches);
	}

	@When("post maintenence batch is run")
	public void whenPostMaintenenceBatchIsRun() {

		List<ProcessBatches> processBatches = new ArrayList<>();

		ProcessBatches postMaintenenceBatch = new ProcessBatches();
		postMaintenenceBatch.setProductType(provider.getString(BATCH_TYPE));
		postMaintenenceBatch.setBatchName(provider.getString(BATCH_NAME_POST_MAINTENENCE));

		processBatches.add(postMaintenenceBatch);

		reconciliationWorkFlow.runPostMaintenenceBatch(processBatches);
	}

	@When("pre-clearing and Loyalty Calc batches are run")
	public void whenPreclearingAndLoyaltyBatchesAreRun() {

		List<ProcessBatches> processBatches = new ArrayList<>();
		ProcessBatches prepaidEodProcessBatch = new ProcessBatches();
		prepaidEodProcessBatch.setProductType(provider.getString(BATCH_TYPE));
		prepaidEodProcessBatch.setBatchName(provider.getString("BATCH_NAME_LOYALTY"));
		prepaidEodProcessBatch.setProductType("");

		ProcessBatches preClearingBatch = new ProcessBatches();
		preClearingBatch.setProductType(provider.getString(BATCH_TYPE));
		preClearingBatch.setBatchName(provider.getString("BATCH_NAME_PRE_CLEARING"));
		preClearingBatch.setProductType(provider.getString("PREPAID_PRODUCT_TYPE"));

		processBatches.add(preClearingBatch);
		processBatches.add(prepaidEodProcessBatch);

		reconciliationWorkFlow.runPreClearingAndLoyaltyCalcBatch(processBatches);
	}

}
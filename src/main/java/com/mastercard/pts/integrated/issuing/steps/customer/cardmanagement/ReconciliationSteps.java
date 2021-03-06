package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReconciliationWorkFlow;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProcessBatchesFlows;

@Component
public class ReconciliationSteps {
	private static final String BATCH_TYPE = "BATCH_TYPE";
	private static final String BATCH_NAME_POST_MAINTENANCE = "BATCH_NAME_POST_MAINTENANCE";
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;
	
	@Autowired
	private ProcessBatches processBatch;
	
	@Autowired
	private ProcessBatchesFlows processBatchesFlows;

	@Then("verify report for transactions with Program Balance Summary is downloaded")
	public void verifyReportForTransactionsWithProgramBalanceSummaryIsDownloaded() {
		Assert.assertTrue(reconciliationWorkFlow.verifyReportGenerationRecon());
	}

	@Then("pre-clearing and Pre-EOD batches are run")
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

	@When("post maintenance batch is run")
	public void whenPostMaintenanceBatchIsRun() {

		ProcessBatches postMaintenanceBatch = new ProcessBatches();
		postMaintenanceBatch.setBatchName(provider.getString(BATCH_NAME_POST_MAINTENANCE));
		reconciliationWorkFlow.runPostMaintenanceBatch(postMaintenanceBatch);
	}
	
	@Then("pre-clearing and Loyalty Calc batches are run")
	@When("pre-clearing and Loyalty Calc batches are run")
	public void whenPreclearingAndLoyaltyBatchesAreRun() {

		List<ProcessBatches> processBatches = new ArrayList<>();
		ProcessBatches preClearingBatch = new ProcessBatches();
		preClearingBatch.setProductType(provider.getString(BATCH_TYPE));
		preClearingBatch.setBatchName(provider.getString("BATCH_NAME_PRE_CLEARING"));
		preClearingBatch.setProductType(provider.getString("PREPAID_PRODUCT_TYPE"));

		ProcessBatches prepaidEodProcessBatch = new ProcessBatches();
		prepaidEodProcessBatch.setProductType(provider.getString(BATCH_TYPE));
		prepaidEodProcessBatch.setBatchName(provider.getString("BATCH_NAME_LOYALTY"));
		prepaidEodProcessBatch.setProductType("");

		processBatches.add(preClearingBatch);
		processBatches.add(prepaidEodProcessBatch);
		
		if(provider.getString("BATCH_NAME_EOD") != null && provider.getString("BATCH_NAME_EOD").equalsIgnoreCase("End Of Day - Credit [DAILY]")) {
			prepaidEodProcessBatch = null;
			prepaidEodProcessBatch = new ProcessBatches();
			prepaidEodProcessBatch.setProductType(provider.getString(BATCH_TYPE));
			prepaidEodProcessBatch.setBatchName(provider.getString("BATCH_NAME_EOD"));
			prepaidEodProcessBatch.setProductType("");
			processBatches.add(prepaidEodProcessBatch);
		}

		reconciliationWorkFlow.runPreClearingAndLoyaltyCalcBatch(processBatches);
	}
	
	@When("user processes $batchName system internal batch for $productType")
	@Then("user processes $batchName system internal batch for $productType")
	public void processBillingBatchForCredit(String batchName,String productType){
		ProcessBatches batch = new ProcessBatches();
		batch.setProductType(ProductType.fromShortName(productType));
		batch.setBatchName(batchName);
		ProcessBatches batches = reconciliationWorkFlow.runCreditBillingBatch(batch);
		assertEquals("SUCCESS [2]", batches.getStatus());
		context.put(ContextConstants.PROCESSED_BATCHES, batches);
	}
	
	@When("user run $batchName system internal batch")
	public void runStatementExtractBatch(String batchName){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName(batchName);
		reconciliationWorkFlow.processStatementExtractBatch(batch);
	}
	
	@When("user processes batch $batchName for $product")
	public void processPaymentUploadBatchForCredit(String batchName, String product)
	{
		String fileName = context.get(ConstantData.PAYMENT_UPLOAD_FILE_NAME);
		processBatch.setJoBID(processBatchesFlows.processUploadBatches(batchName, fileName));
		SimulatorUtilities.wait(5000);
		Assert.assertTrue(processBatchesFlows.verifyFileProcessFlowsUpload(processBatch, fileName));
	}

}

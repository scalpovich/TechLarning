package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchJobHistory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchJobHistoryFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BatchJobHistoryWorkflow;

@Component
public class BatchJobHistorySteps {

	
	
	@Autowired
	BatchJobHistoryWorkflow batchJobHistoryWorkflow;

	@Autowired
	BatchJobHistory batchjobhistory;

	@Autowired
	BulkDeviceRequestbatch bulkdevicerequestbatch;

	@Autowired
	BatchJobHistoryFlows batchjobhistoryflows;
	
	@Autowired
	TestContext context;

	@Then("Statement download batch is available on Batch Job History Page")
	public void statementDownloadBatchIsAvailableOnBatchJobHistoryPage() {
		String[] result = batchJobHistoryWorkflow.verifyTodaysRecordInBatchJobHistory();
		assertThat("Statement Not Downloaded Today!", result[0], is(DateUtils.getLocalDateInYYYYMMDD()));
		assertThat("Statement (Type) Not Downloaded", result[1], is("Statement Download [STATEMENT_DOWNLOAD]"));
	}

	@When("user checks for the $productionbatch batch success status for $batchType batch")
	public void checkBatchStatus(@Named("productionbatch") String productionbatch,
			@Named("batchType") String batchType) {
		batchjobhistory.setBatchType(batchType);
		if (productionbatch.equals("Pre-Production")) {
			batchjobhistory.setJobIdBatchJobHistory(bulkdevicerequestbatch.getPreProductionSourceJobid());
		} else {
			batchjobhistory.setJobIdBatchJobHistory(bulkdevicerequestbatch.getJobId());
		}
		batchjobhistoryflows.CheckBatchJobHistory(batchjobhistory);
	}
	
	
	@When("user verifies batch job history with job id")
	@Then("user verifies batch job history with job id")
	public void userSearchBatchJobHistoryWithJobID() {
		ProcessBatches batches = context.get(ContextConstants.PROCESSED_BATCHES);
		assertEquals("SUCCESS [2]", batchJobHistoryWorkflow.searchRecordByJobIDInBatchJobHistory(batches).getStatus());
	}
	
	@When("check status in batch job history for $batchType batch and $batchName")
	public boolean checkStatusInBatchJobHistory(String batchType, String batchName) {
		if (batchType.equalsIgnoreCase("DOWNLOAD")) {
			batchjobhistory.setBatchType(Constants.BATCH_TYPE_DOWNLOAD);
		}
		SimulatorUtilities.wait(3000);
		if (batchName.equalsIgnoreCase("CLIENT_PHOTO_BATCH")) {
			batchjobhistory.setBatch(Constants.CLIENT_PHOTO_FLAT_FILE_DOWNLOAD_BATCH);
		} else {
			if (batchName.equalsIgnoreCase("CardholderDump")) {
				batchjobhistory.setBatch(Constants.CARDHOLDER_DUMP_BATCH);
			}
		}
		batchjobhistory.setJobIdBatchJobHistory(context.get(ContextConstants.JOB_ID));
		batchjobhistory.setFromdate(DateUtils.currentDateddMMyyyy());
		batchjobhistory.setToDate(DateUtils.currentDateddMMyyyy());
		return batchjobhistoryflows.checkBatchStatusInBatchJobHistory(batchjobhistory);
	}
}
